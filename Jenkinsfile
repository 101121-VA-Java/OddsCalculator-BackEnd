pipeline {
   agent any
   
    environment {
        PORT_HOST="8081"
        PORT_CONT="8080"
        IMAGE_TAG="oddsCalculator"
        CONTAINER_NAME="oddsCalculator"
        DB_URL='jdbc:postgresql://oddscalc.cv2qlth3lytm.us-east-2.rds.amazonaws.com:5432/postgres?currentSchema=public'
        DB_USER='scrumbob'
        DB_PASS='devpants'
    }

   stages {
      stage('checkout'){
          steps {
            script {
                properties([pipelineTriggers([githubPush()])])
            }
            git branch: 'main', url: 'https://github.com/101121-VA-Java/OddsCalculator-BackEnd.git'

          }
      }
      stage('clean') {
         steps {
            sh 'mvn clean'
         }
      }
      stage('package') {
         steps {
            sh 'mvn package -Dmaven.test.skip=true -Pprod'
         }
      }
      stage('remove previous image if exists') {
            steps {
                sh 'docker rmi -f ${IMAGE_TAG} || true'
            }
        }

       stage('create image') {
            steps {
                sh 'docker build -t ${IMAGE_TAG} -f Dockerfile .'
            }
        }
        stage('remove previous container if exists') {
            steps {
                sh 'docker stop ${CONTAINER_NAME} || true'
            }
        }
        stage('create container') {
            steps {
                sh 'docker run -e DB_URL=${DB_URL} -e DB_USER=${DB_USER} -e DB_PASS=${DB_PASS} -d --rm -p ${PORT_HOST}:${PORT_CONT} --name ${CONTAINER_NAME} ${IMAGE_TAG} '
            }
        }
    }
}