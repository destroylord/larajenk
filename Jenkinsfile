pipeline {
    agent any

    environment {
        APP_ENV = 'testing'
    }

    stages {
        stage('Setup Testing Environment') {
            steps {
                sh 'composer install --no-interaction'
                sh 'cp .env.example .env'
                sh 'php artisan key:generate'
            }
        }

        stage('Run Tests') {
            steps {
                sh 'php artisan test'
            }
        }
    }

    post {
        success {
            echo '✅ Testing berhasil!'
        }
        failure {
            echo '❌ Testing gagal! Periksa error pada log.'
        }
    }
}
