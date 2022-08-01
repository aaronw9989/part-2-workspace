package gov.irs.enumtype;

import gov.irs.TaxPayer;

public interface IRS {

  void collectTaxes();

  void register(TaxPayer payer);

  // static method CAN NOT be abstract
  static IRS getInstance() {
    return IRSEnum.INSTANCE;
  }


}
