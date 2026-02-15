using System;
using System.Collections.Generic;
using System.Text;
using Newtonsoft.Json;

namespace APIVerve.API.PurchasingPower
{
    /// <summary>
    /// Query options for the Purchasing Power API
    /// </summary>
    public class PurchasingPowerQueryOptions
    {
        /// <summary>
        /// The dollar amount to convert
        /// </summary>
        [JsonProperty("amount")]
        public string Amount { get; set; }

        /// <summary>
        /// Starting period in YYYY or YYYY-MM format (data available from 1947)
        /// </summary>
        [JsonProperty("from")]
        public string From { get; set; }

        /// <summary>
        /// Ending period in YYYY or YYYY-MM format. Omit for current.
        /// </summary>
        [JsonProperty("to")]
        public string To { get; set; }
    }
}
