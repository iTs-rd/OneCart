import time
import os


def AccountService():
    os.system("mvn -f .//AccountService clean install")
    os.system("docker build -t itsrd/account-service:latest .//AccountService")
    os.system("docker push itsrd/account-service:latest")
 
def CloudGateway():
    os.system("mvn -f .//CloudGateway clean install")
    os.system("docker build -t itsrd/cloud-gateway:latest .//CloudGateway")
    os.system("docker push itsrd/cloud-gateway:latest")
 
def ConfigServer():
    os.system("mvn -f .//ConfigServer clean install")
    os.system("docker build -t itsrd/config-server:latest .//ConfigServer")
    os.system("docker push itsrd/config-server:latest")
 
def OrderService():
    os.system("mvn -f .//OrderService clean install")
    os.system("docker build -t itsrd/order-service:latest .//OrderService")
    os.system("docker push itsrd/order-service:latest")

def PaymentService():
    os.system("mvn -f .//PaymentService clean install")
    os.system("docker build -t itsrd/payment-service:latest .//PaymentService")
    os.system("docker push itsrd/payment-service:latest")
 
def ProductService():
    os.system("mvn -f .//ProductService clean install")
    os.system("docker build -t itsrd/product-service:latest .//ProductService")
    os.system("docker push itsrd/product-service:latest")
 
def ServiceRegistry():
    os.system("mvn -f .//ServiceRegistry clean install")
    os.system("docker build -t itsrd/service-registry:latest .//ServiceRegistry")
    os.system("docker push itsrd/service-registry:latest")


if __name__ =="__main__":
    inital_time = time.time()

    AccountService()
    CloudGateway()
    ConfigServer()
    OrderService()
    PaymentService()
    ProductService()
    ServiceRegistry()


    time_taken=time.time()-inital_time

    print("Time taken = "+str(time_taken//1)+" seconds")

