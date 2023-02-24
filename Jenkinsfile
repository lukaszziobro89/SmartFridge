pipeline {
  agent any
  tools {
    maven 'maven-3.6.3' 
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
