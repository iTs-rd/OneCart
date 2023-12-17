import threading
import time
import os


def AccountService():
    os.system("mvn -f .//AccountService clean install")
    os.system("docker build -t itsrd/account-service:1.0 .//AccountService")
    os.system("docker push itsrd/account-service:1.0")
 
def CloudGateway():
    os.system("mvn -f .//CloudGateway clean install")
    os.system("docker build -t itsrd/cloud-gateway:1.0 .//CloudGateway")
    os.system("docker push itsrd/cloud-gateway:1.0")
 
def ConfigServer():
    os.system("mvn -f .//ConfigServer clean install")
    os.system("docker build -t itsrd/config-server:1.0 .//ConfigServer")
    os.system("docker push itsrd/config-server:1.0")
 
def OrderService():
    os.system("mvn -f .//OrderService clean install")
    os.system("docker build -t itsrd/order-service:1.0 .//OrderService")
    os.system("docker push itsrd/order-service:1.0")

def PaymentService():
    os.system("mvn -f .//PaymentService clean install")
    os.system("docker build -t itsrd/payment-service:1.0 .//PaymentService")
    os.system("docker push itsrd/payment-service:1.0")
 
def ProductService():
    os.system("mvn -f .//ProductService clean install")
    os.system("docker build -t itsrd/product-service:1.0 .//ProductService")
    os.system("docker push itsrd/product-service:1.0")
 
def ServiceRegistry():
    os.system("mvn -f .//ServiceRegistry clean install")
    os.system("docker build -t itsrd/service-registry:1.0 .//ServiceRegistry")
    os.system("docker push itsrd/service-registry:1.0")


if __name__ =="__main__":
    inital_time = time.time()

    accountService = threading.Thread(target=AccountService)
    cloudGateway = threading.Thread(target=CloudGateway)
    configServer = threading.Thread(target=ConfigServer)
    orderService = threading.Thread(target=OrderService)
    paymentService = threading.Thread(target=PaymentService)
    productService = threading.Thread(target=ProductService)
    serviceRegistry = threading.Thread(target=ServiceRegistry)



    accountService.start()
    cloudGateway.start()
    configServer.start()
    orderService.start()
    paymentService.start()
    productService.start()
    serviceRegistry.start()

    accountService.join()
    cloudGateway.join()
    configServer.join()
    orderService.join()
    paymentService.join()
    productService.join()
    serviceRegistry.join()


    time_taken=time.time()-inital_time

    print("Time taken = "+str(time_taken//1)+" seconds")

