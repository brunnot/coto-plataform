 - Loadbalance: OK
 	- Apontando para 2 serviços de GTW: OK
 	- Reload de config sem reset: nginx -t e nginx -s reload : OK
 		- Ex. docker exec coto-plataform-load-balancer-1 nginx -s reload
 
 - API Gateway: OK
 	- Escalando para 2 instâncias: OK
 	- Header de identificação: OK
 	- Autenticar: OK
 	- Autenticar com 2 instâncias: OK
 	- RateLimit com 1 instância: TBD
 	- RateLimit com 2 instância: TBD
 
 - Serviço de API: OK
 	- Escalando para 2 instâncias: OK
 	- Organizar o LOG para indentificar as várias instâncias: TBD
 	- Verificar se é possível ler o log das diveras instÂncias juntos no docker: TBD
 	- Autenticar: OK
 	- Autenticar com 2 instâncias: OK