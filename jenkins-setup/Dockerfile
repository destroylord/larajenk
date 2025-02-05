FROM jenkins/jenkins:lts

# Install Docker CLI untuk bisa build dalam pipeline (opsional)
USER root
RUN apt-get update && apt-get install -y docker.io

# Install semua plugin dalam satu perintah
RUN jenkins-plugin-cli --plugins \
  configuration-as-code \
  git \
  workflow-aggregator \
  pipeline-stage-view \
  blueocean \
  credentials-binding \
  ssh-slaves \
  docker-workflow


  # Buat folder jika belum ada dan pastikan permission benar

RUN mkdir -p /var/jenkins_home/init.groovy.d && \
    mkdir -p /var/jenkins_home/casc_configs && \
    chown -R jenkins:jenkins /var/jenkins_home

# Pindah ke user jenkins sebelum copy file
USER jenkins

# Copy konfigurasi auto setup
COPY --chown=jenkins:jenkins casc.yaml /var/jenkins_home/casc_configs/casc.yaml
COPY --chown=jenkins:jenkins init.groovy.d/ /var/jenkins_home/init.groovy.d/

# Set environment untuk konfigurasi otomatis
ENV CASC_JENKINS_CONFIG=/var/jenkins_home/casc_configs/casc.yaml

# Expose port Jenkins
EXPOSE 8080
