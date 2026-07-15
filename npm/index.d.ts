declare module '@apiverve/purchasingpower' {
  export interface purchasingpowerOptions {
    api_key: string;
    secure?: boolean;
  }

  /**
   * Describes fields the current plan does not unlock. Locked fields arrive as null
   * in `data`; `locked_fields` names them, using dot paths for nested fields.
   * Absent when the plan unlocks everything.
   */
  export interface PremiumInfo {
    message: string;
    upgrade_url: string;
    locked_fields: string[];
  }

  export interface purchasingpowerResponse {
    status: string;
    error: string | null;
    data: PurchasingPowerData;
    code?: number;
    premium?: PremiumInfo;
  }


  interface PurchasingPowerData {
      originalAmount:      number | null;
      originalPeriod:      null | string;
      adjustedAmount:      number | null;
      adjustedPeriod:      null | string;
      cumulativeInflation: number | null;
      multiplier:          number | null;
      explanation:         null | string;
      fromCPI:             number | null;
      toCPI:               number | null;
  }

  export default class purchasingpowerWrapper {
    constructor(options: purchasingpowerOptions);

    execute(callback: (error: any, data: purchasingpowerResponse | null) => void): Promise<purchasingpowerResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: purchasingpowerResponse | null) => void): Promise<purchasingpowerResponse>;
    execute(query?: Record<string, any>): Promise<purchasingpowerResponse>;
  }
}
