output "realm_id" {
  description = "Keycloak realm ID"
  value       = keycloak_realm.messaging.id
}

output "api_gateway_client_secret" {
  description = "API Gateway Client Secret"
  value       = keycloak_openid_client.api_gateway.client_secret
  sensitive   = true
}

output "messages_service_client_secret" {
  description = "Messages Service Client Secret"
  value       = keycloak_openid_client.messages_service.client_secret
  sensitive   = true
}

output "users" {
  description = "Initial users"
  value = [for user in [keycloak_user.jose_paulo, keycloak_user.john_doe] : {
    id         = user.id
    first_name = user.first_name
    last_name  = user.last_name
    email      = user.email
  }]
}
