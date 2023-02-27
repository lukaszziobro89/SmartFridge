pipeline {
    agent any

    tools {
        maven "mvn-3.9.0"
        jdk "JDK"
    }

    stages {
        stage('Build') {
            steps {
                sh """ mvn -v"""                
            }
        }
//         stage('Sonar') {
//             steps {
//               sh """/var/jenkins_home/tools/hudson.tasks.Maven_MavenInstallation/mvn-3.9.0/bin/mvn clean verify sonar:sonar -Dsonar.host.url=https://data-parachuting.com:30620/sonar -Dsonar.projectKey=Fridge"""
//             }
//         }
//         stage('SonarQube Analysis') {
//              def scannerHome = tool 'DPSonar';
//              withSonarQubeEnv() {
//             	 sh "${scannerHome}/bin/sonar-scanner"
//         	}
//         }
        stage('SonarQube Analysis') {
//             def mvn = tool 'mvn-3.9.0';
            withSonarQubeEnv() {
              sh "/var/jenkins_home/tools/hudson.tasks.Maven_MavenInstallation/mvn-3.9.0/bin/mvn clean verify sonar:sonar -Dsonar.projectKey=Fridge"
            }
        }
     }
}
