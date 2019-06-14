package com.distributor.types;

import com.distributor.enums.MyRole;
import com.distributor.models.MyRoleJsonHashSet;
import com.distributor.types.motherclasses.MotherClassType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;

public class MyRoleJsonType extends MotherClassType {

    private static HashSet<MyRole> myRoles;
    private static MyRoleJsonHashSet myRoleJsonHashSet;

    public MyRoleJsonType() {
    }

    @Override
    public Class returnedClass() {
        return MyRoleJsonHashSet.class;
    }

    @Override
    public Object nullSafeGet(ResultSet rs, String[] names,
                              SharedSessionContractImplementor session, Object owner)
            throws HibernateException, SQLException {

        myRoleJsonHashSet = new MyRoleJsonHashSet();
        myRoles = new HashSet();

        if (rs.wasNull()) {
            return null;
        } else {

            String nodeString = rs.getString(names[0]);

            ObjectMapper mapper = new ObjectMapper();
            try {
                JsonNode node = mapper.readTree(nodeString);

                //un noeud
                JsonNode myRolesNode = node.path("myRoles");

                for (JsonNode j : myRolesNode) {

                    if (j.asText().equals("VISITOR")) {
                        myRoles.add(MyRole.VISITOR);
                    } else if (j.asText().equals("USER")) {
                        myRoles.add(MyRole.USER);
                    } else if (j.asText().equals("ADMINISTRATOR")) {
                        myRoles.add(MyRole.ADMINISTRATOR);
                    }
                    myRoleJsonHashSet.setMyRoles(myRoles);
                }
                return myRoleJsonHashSet;
            }catch(Exception ex){
                ex.printStackTrace();
            }

        }

        return null;
    }
}
