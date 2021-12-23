pipeline {
   agent any
   
    environment {
        PORT_HOST="8081"
        PORT_CONT="8080"
        IMAGE_TAG="oddscalculator"
        CONTAINER_NAME="oddscalculator"
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
            git branch: 'testbranch', url: 'https://github.com/101121-VA-Java/OddsCalculator-BackEnd.git'

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
                sh 'docker rmi -f oddscalculator || true'
            }
        }

       stage('create image') {
            steps {
                sh 'docker build -t oddscalculator -f Dockerfile .'
            }
        }
        stage('remove previous container if exists') {
            steps {
                sh 'docker stop oddscalculator || true'
            }
        }
        stage('create container') {
            steps {
                sh 'docker run -e DB_URL=${DB_URL} -e DB_USER=${DB_USER} -e DB_PASS=${DB_PASS} -d --rm -p ${PORT_HOST}:${PORT_CONT} --name oddscalculator oddscalculator '
            }
        }
    
    }
}
