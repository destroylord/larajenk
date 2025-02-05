pipeline {
    agent any

    environment {
        APP_ENV = 'testing'
        // DB_CONNECTION = 'mysql'
        // DB_DATABASE = 'database/database.sqlite'
    }

    stages {
        // stage('Checkout Code') {
        //     steps {
        //         git branch: 'main', credentialsId: 'git-credentials-id', url: 'https://github.com/destroylord/larajenk'
        //     }
        // }

        // stage('Setup Environment') {
        //     steps {
        //         sh 'cp .env.example .env'
        //         sh 'composer dump-autoload'
        //         sh 'php artisan key:generate'
        //         sh 'php artisan migrate:fresh --seed'
        //         sh 'composer install --no-interaction --prefer-dist --optimize-autoloader'
        //     }
        // }

        // stage('Run Migrations') {
        //     steps {
        //         sh 'php artisan migrate --seed'
        //     }
        // }

        stage('Run Tests') {
            steps {
                sh 'php artisan test'
            }
        }

        // stage('Deploy to Server') {
        //     steps {
        //         sshagent (credentials: ['server-ssh-key']) {
        //             sh '''
        //             ssh user@your-server "cd /var/www/laravel && git pull origin main && composer install --no-dev && php artisan migrate --force && php artisan cache:clear"
        //             '''
        //         }
        //     }
        // }
    }

    post {
        success {
            echo '✅ Build & testing berhasil!'
        }
        failure {
            echo '❌ Build gagal! Periksa error pada log.'
        }
    }
}
