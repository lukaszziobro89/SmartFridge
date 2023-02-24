// node {
//   stage('SCM') {
//     checkout scm
//   }
//   stage('Maven compile project'){
//     step {
//       sh 'mvn clean package'
//     }
//   }
//   stage('SonarQube Analysis') {
//     def scannerHome = tool 'DPSonar';
//     withSonarQubeEnv() {
//       sh "${scannerHome}/bin/sonar-scanner"
//     }
//   }
// }

pipeline {
    agent any

    tools {
        maven "mvn-3.9.0"
        jdk "JDK"
    }

    stages {
        stage('Initialize'){
            steps{
                echo "PATH = ${M2_HOME}/bin:${PATH}"
                echo "M2_HOME = /opt/maven"
            }
        }
        stage('Build') {
            steps {
                dir("/var/lib/jenkins/workspace/New_demo/my-app/") {
                sh 'mvn -B -DskipTests clean package'
                }
            
            }
        }
     }
    post {
       always {
          junit(
        allowEmptyResults: true,
        testResults: '*/test-reports/.xml'
      )
      }
   } 
}
