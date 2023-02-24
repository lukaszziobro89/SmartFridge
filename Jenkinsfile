pipeline {
  agent any
  tools {
    maven 'Maven 3.3.9'
    jdk 'jdk8'
  }
  stages {
    stage ('Maven compile project') {
      steps {
        sh 'mvn clean package'
      }
    }
    stage('SonarQube Analysis') {
      steps {
        def scannerHome = tool 'DPSonar';
        withSonarQubeEnv() {
          sh "${scannerHome}/bin/sonar-scanner"
        }
      }
    }
  }
}
