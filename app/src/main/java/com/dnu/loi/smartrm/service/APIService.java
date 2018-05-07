package com.dnu.loi.smartrm.service;

import com.dnu.loi.smartrm.entity.DeviceRegistration;
import com.dnu.loi.smartrm.entity.Dishes;
import com.dnu.loi.smartrm.entity.DishesType;
import com.dnu.loi.smartrm.entity.Floor;
import com.dnu.loi.smartrm.entity.Invoice;
import com.dnu.loi.smartrm.entity.Menu;
import com.dnu.loi.smartrm.entity.Order;
import com.dnu.loi.smartrm.entity.Table;
import com.dnu.loi.smartrm.entity.TableType;
import com.dnu.loi.smartrm.entity.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Mô tả:
 * <p>
 * Created by loi on 03/05/2018.
 */

public interface APIService {
    @GET("/api/Dishes")
    Call<List<Dishes>> getDishes();

    @GET("/api/DishesType")
    Call<List<DishesType>> getDishesType();

    @GET("/api/Floor")
    Call<List<Floor>> getFloors();

    @GET("/api/Table")
    Call<List<Table>> getTables();

    @GET("/api/TableType")
    Call<List<TableType>> getTableTypes();

    @GET("/api/Order")
    Call<List<Order>> getOrders();

    @PUT("/api/Order/{id}")
    Call<Order> putOrder(@Path("id") String id, @Body Order order);

    @POST("/api/Order")
    Call<Order> postOrder(@Body Order order);

    @DELETE("/api/Order/{id}")
    Call<Order> deleteOrder(@Path("id") String id);

    @GET("/api/Invoice")
    Call<List<Invoice>> getInvoices();

    @PUT("/api/Invoice/{id}")
    Call<Invoice> putInvoice(@Path("id") String id, @Body Invoice invoice);

    @POST("/api/Invoice")
    Call<Invoice> postInvoice(@Body Invoice invoice);

    @DELETE("/api/Invoice/{id}")
    Call<Invoice> deleteInvoice(@Path("id") String id);

    @POST("/api/Login")
    Call<User> login(@Body User user);

    @POST("/api/DeviceRegistration")
    Call<DeviceRegistration> postDeviceRegistration(@Body DeviceRegistration deviceRegistration);

    @GET("/api/MenuType")
    Call<List<Menu>> getMenus();

}
