# setup mysql
docker-compose -f docker/docker-compose.yml up -d

# download dependencies
./mvnw clean verify

# install git pre-push hook
chmod +x pre-push
cp pre-push .git/hooks
