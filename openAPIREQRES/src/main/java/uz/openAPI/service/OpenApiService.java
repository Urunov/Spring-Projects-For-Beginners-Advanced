package uz.openAPI.service;

import uz.openAPI.model.users.ListUsers;
import uz.openAPI.model.users.SingleUser;

public interface OpenApiService {
    //
   public SingleUser singleUser();
   public ListUsers getAll();
}
