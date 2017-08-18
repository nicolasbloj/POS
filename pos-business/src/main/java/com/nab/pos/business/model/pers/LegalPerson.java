package com.nab.pos.business.model.pers;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@MappedSuperclass
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)

public class LegalPerson extends Person implements Serializable {


  private static final long serialVersionUID = 1L;

  @Column(name = "nombreNegocio", nullable = false, unique = false)
  @Getter
  private String businessName;
  @Column(name = "nombreComercial", nullable = true, unique = false)
  @Getter
  private String tradeName;
  @Column(name = "cuit", nullable = false, unique = false)
  @Getter
  private String taxId;// cuit
  @Column(name = "actividadPrincipal", nullable = false, unique = false)
  @Getter
  private String principalActivity;
  @Column(name = "actividadSecundaria", nullable = true, unique = false)
  @Getter
  private String secundaryActivity;
  @Column(name = "principalProductoServicio", nullable = false, unique = false)
  @Getter
  private String principalProductService;
  @Column(name = "industria", nullable = false, unique = false)
  @Getter
  private String industry;
  @Column(name = "fechaConstitucion", nullable = false, unique = false)
  @Getter
  @Temporal(TemporalType.DATE)
  private java.util.Date constitutionDate;

  public LegalPerson() {}

  public LegalPerson(String businessName, String tradeName, String taxId, String principalActivity,
      String secundaryActivity, String principalProductService, String industry,
      java.util.Date constitutionDate, String phone, String cellPhone, String email) {
    super(phone, cellPhone, email);
    this.businessName = businessName;
    this.tradeName = tradeName;
    this.taxId = taxId;
    this.principalActivity = principalActivity;
    this.secundaryActivity = secundaryActivity;
    this.principalProductService = principalProductService;
    this.industry = industry;
    this.constitutionDate = constitutionDate;
  }

  // id for puts
  public LegalPerson(Long id, String businessName, String tradeName, String taxId,
      String principalActivity, String secundaryActivity, String principalProductService,
      String industry, java.util.Date constitutionDate, String phone, String cellPhone,
      String email) {
    super(id, phone, cellPhone, email);
    this.businessName = businessName;
    this.tradeName = tradeName;
    this.taxId = taxId;
    this.principalActivity = principalActivity;
    this.secundaryActivity = secundaryActivity;
    this.principalProductService = principalProductService;
    this.industry = industry;
    this.constitutionDate = constitutionDate;
  }

}
