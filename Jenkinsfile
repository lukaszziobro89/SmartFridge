node {
  stage('SCM') {
    checkout scm
  }
  stage('Maven compile project'){
    steps {
      sh 'mvn clean package'
    }
  }
  stage('SonarQube Analysis') {
    def scannerHome = tool 'DPSonar';
    withSonarQubeEnv() {
      sh "${scannerHome}/bin/sonar-scanner"
    }
  }
}
