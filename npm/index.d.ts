declare module '@apiverve/purchasingpower' {
  export interface purchasingpowerOptions {
    api_key: string;
    secure?: boolean;
  }

  export interface purchasingpowerResponse {
    status: string;
    error: string | null;
    data: PurchasingPowerData;
    code?: number;
  }


  interface PurchasingPowerData {
      originalAmount:      number;
      originalPeriod:      string;
      adjustedAmount:      number;
      adjustedPeriod:      string;
      cumulativeInflation: number;
      multiplier:          number;
      explanation:         string;
      fromCPI:             number;
      toCPI:               number;
  }

  export default class purchasingpowerWrapper {
    constructor(options: purchasingpowerOptions);

    execute(callback: (error: any, data: purchasingpowerResponse | null) => void): Promise<purchasingpowerResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: purchasingpowerResponse | null) => void): Promise<purchasingpowerResponse>;
    execute(query?: Record<string, any>): Promise<purchasingpowerResponse>;
  }
}
