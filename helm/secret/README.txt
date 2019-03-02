# This certificates have been generated via command:
sudo openssl req -x509 -nodes -days 365 -newkey rsa:2048 -keyout tls.key -out tls.crt

# After creation of the certificates, installation of the secrete was performed with next command:
kubectl create secret tls guardarpunto-tls-cert --key tls.key --cert tls.crt
