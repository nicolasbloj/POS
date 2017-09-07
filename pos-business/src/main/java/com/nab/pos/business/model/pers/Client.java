package com.nab.pos.business.model.pers;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Entity
@Table(name = "CLIENTE", indexes = {@Index(columnList = "codigo", name = "codigo_hidx")})
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Client extends LegalPerson implements Serializable {

  private static final long serialVersionUID = 1L;

  @Column(name = "codigo")
  @Getter
  private String code;

  public Client(String code, String businessName, String tradeName, String taxId,
      String principalActivity, String secundaryActivity, String principalProductService,
      String industry, java.util.Date constitutionDate, String phone, String cellPhone,
      String email) {
    super(businessName, tradeName, taxId, principalActivity, secundaryActivity,
        principalProductService, industry, constitutionDate, phone, cellPhone, email);
    this.code = code;
  }

  // for put
  public Client(Long id, String code, String businessName, String tradeName, String taxId,
      String principalActivity, String secundaryActivity, String principalProductService,
      String industry, java.util.Date constitutionDate, String phone, String cellPhone,
      String email) {
    super(id, businessName, tradeName, taxId, principalActivity, secundaryActivity,
        principalProductService, industry, constitutionDate, phone, cellPhone, email);
    this.code = code;
  }

  public Client() {}


}
