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
        stage('Build') {
            steps {
                sh 'mvn -v'
            }
        }
     }
}
