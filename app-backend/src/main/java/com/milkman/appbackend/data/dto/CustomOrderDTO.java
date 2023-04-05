package com.milkman.appbackend.data.dto;

import com.milkman.appbackend.data.entity.Package;
import com.milkman.appbackend.data.entity.Plan;
import com.milkman.appbackend.data.entity.Supplier;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Data
public class CustomOrderDTO {

    private String supplierName;

    private String orderNumber;

    private String orderStatus;

    private String orderName;
}
