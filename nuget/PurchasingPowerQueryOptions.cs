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
        public double Amount { get; set; }

        /// <summary>
        /// Starting year (YYYY format, data available from 1947)
        /// </summary>
        [JsonProperty("from")]
        public string From { get; set; }

        /// <summary>
        /// Ending year (YYYY format). Omit for current.
        /// </summary>
        [JsonProperty("to")]
        public string To { get; set; }
    }
}
