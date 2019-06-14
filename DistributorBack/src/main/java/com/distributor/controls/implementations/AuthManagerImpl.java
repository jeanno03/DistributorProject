package com.distributor.controls.implementations;

import com.distributor.constants.MyConstant;
import com.distributor.controls.interfaces.IAuthManager;
import com.distributor.controls.motherclasses.MyUserManagerImpl;
import com.distributor.entities.MyUser;
import com.distributor.models.Credential;
import com.distributor.statics.MyStatic;
import com.distributor.tools.MathsTool;
import org.jose4j.jwk.RsaJsonWebKey;
import org.jose4j.jws.AlgorithmIdentifiers;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.lang.JoseException;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class AuthManagerImpl extends MyUserManagerImpl implements IAuthManager, MathsTool {

    @Inject
    MyStatic myStatic;

    public AuthManagerImpl() {
    }

    @Override
    public String getConnectReturnToken(Credential credential){

        String jwt = null;

        try {
            //d'abord un boolean
            boolean testCredential = testCredential(credential);
            System.out.println("login : " + credential.getLogin());
            System.out.println("getPassword : " + credential.getPassword());
            System.out.println("testCredential : " + testCredential);

            if(testCredential) {

                //je dois retrouver l'user dans bdd
                MyUser myUser = getMyUserByLogin(credential.getLogin()).get(0);

                List<String>  rolesString = new ArrayList<>();

                myUser.getMyRoleJsonHashSet().getMyRoles().forEach(r -> rolesString.add(r.getType()));

                int kidRandom = generateRandmoKid();

                RsaJsonWebKey rsaJsonWebKey = (RsaJsonWebKey) myStatic.getJsonWebKeys().get(kidRandom);

                System.out.println("MyStatic.jsonWebKeys.get(kidRandom) : " + myStatic.getJsonWebKeys().get(kidRandom));

                JwtClaims jwtClaims = new JwtClaims();
                // Create the Claims, which will be the content of the JWT
                //émetteur
                jwtClaims.setIssuer(MyConstant.DOMAIN);
                jwtClaims.setExpirationTimeMinutesInTheFuture(120);
                jwtClaims.setGeneratedJwtId();
                jwtClaims.setIssuedAtToNow();
                jwtClaims.setNotBeforeMinutesInThePast(2);
                jwtClaims.setSubject(credential.getLogin());
                jwtClaims.setStringListClaim(MyConstant.ROLES, rolesString);

                JsonWebSignature jsonWebSignature = new JsonWebSignature();
                jsonWebSignature.setPayload(jwtClaims.toJson());

                jsonWebSignature.setKeyIdHeaderValue(rsaJsonWebKey.getKeyId());
                jsonWebSignature.setKey(rsaJsonWebKey.getPrivateKey());

                jsonWebSignature.setAlgorithmHeaderValue(AlgorithmIdentifiers.RSA_USING_SHA256);

                try {

                    jwt=jsonWebSignature.getCompactSerialization();
                    System.out.println("Test connection successfull - login : " + credential.getLogin());
                    System.out.println("Kid number : " + kidRandom);
                }catch(JoseException ex) {
                    ex.printStackTrace();
                }catch(Exception ex) {
                    ex.printStackTrace();
                }

            }
            else
            {
                jwt = null;
                System.out.println("jwt est null : " + jwt);
            }

        }catch(NullPointerException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();
        }
        System.out.println("jwt : " + jwt);
        return jwt;
    }

    private boolean testCredential(Credential credential) {

        Boolean test = false;
        String credentialSha3;

        try {

            credentialSha3 = getStringSha3(credential.getPassword());
            MyUser myUser = getMyUserByLogin(credential.getLogin()).get(0);

            if(credentialSha3.equals(myUser.getHashPassword())) {
                test = true;
            }

        }catch(Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("test connection : " + test);
        return test;
        }


}
