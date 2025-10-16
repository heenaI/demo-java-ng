pipeline {
  agent any
  options { timestamps() }
  stages {
    stage('Backend :: Spring Boot - Build & Test') {
      steps {
        dir('backend-springboot') {
          sh 'mvn -B -DskipTests=false clean verify'
        }
      }
      post {
        always { junit 'backend-springboot/target/surefire-reports/*.xml' }
        success { archiveArtifacts artifacts: 'backend-springboot/target/*.jar', fingerprint: true }
      }
    }
    stage('Backend :: Java EE - Package WAR') {
      steps {
        dir('backend-javaee') {
          sh 'mvn -B clean package'
        }
      }
      post {
        success { archiveArtifacts artifacts: 'backend-javaee/target/*.war', fingerprint: true }
      }
    }
    stage('Frontend :: Angular - Lint & Build') {
      steps {
        dir('frontend-angular') {
          sh 'npm ci || npm install'
          sh 'npm run build --if-present'
        }
      }
      post {
        success { archiveArtifacts artifacts: 'frontend-angular/dist/**', fingerprint: true }
      }
    }
  }
}
