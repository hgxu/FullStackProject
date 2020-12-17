
pipeline {
    agent {
        docker { image 'node:14-alpine' }
    }
    stages {
        stage('Build Project') {
            steps {
                sh 'node --version'
                sh './gradlew build'
            }
        }

        stage('Build image and run service in docker'){
           steps {
                sh 'docker build --build-arg JAR_FILE=build/libs/*.jar -t fullstackproject:2.0 .'
                sh 'docker run -p 8080:8080 -t fullstackproject:2.0'
           }
        }

        stage('Trigger test automation'){
            environment {
                TEST_JOB_NAME = '/test-automation-jobs/'
            }
            steps {
                 echo "Triggering automation suite for environment = ${params.ENVIRONMENT}"
                    script {
                       try {
                            build(
                              job: env.TEST_JOB_NAME,
                              parameters: [string(name: 'ENVIRONMENT', value: params.ENVIRONMENT)],
                              quietPeriod: 2,
                              wait: false
                            )
                          } catch ( e ) {
                            echo """
                              Something went wrong. Check if ${env.TEST_JOB_NAME} Jenkins job is not disabled.
                              Details:
                              ${e.toString()}
                            """
                       }
                 }
            }
        }

    }

    post {
        success {
          script {
            slack.notify(
              repositoryName: env.REPOSITORY_NAME,
              status: 'Success',
              additionalText: '',
              sendSlackNotification: env.SEND_SLACK_NOTIFICATION.toBoolean()
            )
          }
        }
        failure {
          script {
            slack.notify(
              repositoryName: env.REPOSITORY_NAME,
              status: 'Failure',
              additionalText: '',
              sendSlackNotification: env.SEND_SLACK_NOTIFICATION.toBoolean()
            )
          }
        }
      }
}