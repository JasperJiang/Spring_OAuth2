https://github.com/ariphidayat/springmvc-oauth2-example

### Grant Type : Client Credentials

The client can request an access token using only its client credentials (or other supported 
means of authentication) when the client is requesting access to the protected resources 
under its control, or those of another resource owner that have been previously arranged with 
the authorization server (the method of which is beyond the scope of this specification).

The client credentials grant type MUST only be used by confidential clients.

     +---------+                                  +---------------+
     |         |                                  |               |
     |         |>--(A)- Client Authentication --->| Authorization |
     | Client  |                                  |     Server    |
     |         |<--(B)---- Access Token ---------<|               |
     |         |                                  |               |
     +---------+                                  +---------------+

     Figure 2: Client Credentials Flow

The following is how the Grant Type works in this application :

* Request token with header `client_id` and `client_secret` as Basic Authorization and with `client_id` and `grant_type` as parameters.

        curl -X POST -vu client:secret http://localhost:8080/oauth/token -H "Accept: application/json" -d "client_id=clientcred&grant_type=client_credentials"

* We will get JSON response :

        {
			"access_token":"67f262cb-55f6-4c60-a49e-ae0ab8a8438c",
			"token_type":"bearer",
			"expires_in":43199,
			"scope":"trust"
		}

* Access resource with header parameter :

        curl -H "Authorization: Bearer 67f262cb-55f6-4c60-a49e-ae0ab8a8438c" http://localhost:8080/api/user

* If success, will get JSON response :

        user/list
