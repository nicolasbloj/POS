package com.nab.pos.common.dto;



import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;

// usar lombok, noargs.
public class ClientDTO {

  @Getter
  private Long id;
  @Getter
  private String code;
  @Getter
  private String businessName;
  @Getter
  private String tradeName;
  @Getter
  private String taxId;
  @Getter
  private String principalActivity;
  @Getter
  private String secundaryActivity;
  @Getter
  private String principalProductService;
  @Getter
  private String industry;
  // SI NO COLOCO LOCALE Y TOMEZONE ENTONCES RESTA UN DIA. NO SE USA LOCALDATE
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-AR",
      timezone = "America/Argentina/Buenos_Aires")
  @Getter
  private java.util.Date constitutionDate;
  @Getter
  private String phone;
  @Getter
  private String cellPhone;
  @Getter
  private String email;


  public ClientDTO(Long id, String code, String businessName, String tradeName, String taxId,
      String principalActivity, String secundaryActivity, String principalProductService,
      String industry, java.util.Date constitutionDate, String phone, String cellPhone,
      String email) {
    this.id = id;
    this.code = code;
    this.businessName = businessName;
    this.tradeName = tradeName;
    this.taxId = taxId;
    this.principalActivity = principalActivity;
    this.secundaryActivity = secundaryActivity;
    this.principalProductService = principalProductService;
    this.industry = industry;
    this.constitutionDate = constitutionDate;
    this.phone = phone;
    this.cellPhone = cellPhone;
    this.email = email;
  }

  public ClientDTO(String code, String businessName, String tradeName, String taxId,
      String principalActivity, String secundaryActivity, String principalProductService,
      String industry, java.util.Date constitutionDate, String phone, String cellPhone,
      String email) {
    this.code = code;
    this.businessName = businessName;
    this.tradeName = tradeName;
    this.taxId = taxId;
    this.principalActivity = principalActivity;
    this.secundaryActivity = secundaryActivity;
    this.principalProductService = principalProductService;
    this.industry = industry;
    this.constitutionDate = constitutionDate;
    this.phone = phone;
    this.cellPhone = cellPhone;
    this.email = email;
  }

  public ClientDTO() {

  }
}
