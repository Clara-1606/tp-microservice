# tp-microservice

## Explications
Malgré notre implication, nous n'avons pas réussi à arriver au bout du projet pour la partie Kubernetes. 
En effet, nous avons rencontré beaucoup de soucis, tout d'abord avec Java Spring, puis avec Hibernate, la création de la gateway et le service discovery pour que tout communique ensemble. 
Après ça, nous avons rencontré des difficultés à build les images dockers, puis les push sur le docker hub (elles sont disponibles ici : https://hub.docker.com/search?q=bastienbrunet&type=image) 

Enfn, le run des images ne sait pas passé comme prévu, nous avions chacun des erreurs différentes. Soit le service discovery fonctionnait, mais pas les microservices, soit l'inverse, et de même pour la gateway.

Nous n'avons pas lâché, nous avons tous énormément travaillé, cherché des solutions quoiqu'il arrive.

Néanmoins vous pouvez retrouver des fichiers de configuration disponible sur le git que nous pensons correctes pour notre projet (que nous n'avons malheuresement pas pu tester), et voici les démarches que nous aurions voulu faire :

## Kubernetes
### Mariadb
#### Déploiement
Tout d'abord il nous faut une mariadb.
On fait le déploiement d'une mariadb (voir conf)
Cela nous créer un pod, et on va poiuvoir aller dans le shell
```sh
mysql -u root -p
```
On créer notre base de données "quotes". 
```sh
CREATE DATABASE quotes;
```
#### Service
On doit ensuite on doit créer notre service
```sh
kubectl expose deployment/mariadb --type=“ClusterIP” --port=3306
```
On créer un secret pour éviter de mettre directement le mot de passe dans le déploiement : 
```sh
kubectl create secret generic mariadb-root-password --from-literal=root-password=password
```

### Microservices 
On fait notre déploiement (voir conf) en le reliant à notre service mariadb


### Gateway
Pour la gateway, il faut exposer les déploiements de nos microservices
```sh
kubectl expose deployment/quotes-users --type=“ClusterIP” --port=8082
kubectl expose deployment/quotes-quotes --type=“ClusterIP” --port=8080
kubectl expose deployment/quotes-opinions --type=“ClusterIP” --port=8081
```

On doit bien récupérer son nom, et son port (que l'on va uiliser dans notre configuation)
kubectl  get svc
```

Puis on expose à nouveau notre déploiement : 
```sh
kubectl expose deployment/quotes-gateway --type=“ClusterIP” --port=9966
```

Il faudra, dans notre service, éditer le targetPort, pour bien le mettre à 9966

### Ingress 
On va maintenant ouvrir la gateway avec un ingress (voir conf)

(Au préalable nous avons ajouter un ingress
https://docs.ovh.com/gb/en/kubernetes/installing-nginx-ingress/

```sh
helm repo add ingress-nginx https://kubernetes.github.io/ingress-nginx
helm repo update
helm -n ingress-nginx install ingress-nginx ingress-nginx/ingress-nginx --create-namespace
```

Cela creer :
-	un namespace ingress 
-	Avec un deployment nginx 
-	Et un service load balancer

On retrouve toutes les confs helm :
```sh
helm list --all-namespaces
```

On voit le résultat sur : quotes.127.0.0.1.nip.io/quotes

On installe des déploiements qui ont mis en ligne des pods, on expose les déploiements grâce à un service, et on expose ses services à l’extérieur grâce à une route (un ingress) qui est managé par un ingresscontroller

Le service effectue son travail de load Balancer


## Membres du projet :
  - Bastien BRUNET
  - Nans KARAYANNIDIS
  - Clara VESVAL
  - Clément CHARLEMAGNE
