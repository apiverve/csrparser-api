using System;
using System.Collections.Generic;
using System.Text;
using Newtonsoft.Json;

namespace APIVerve.API.CSRParser
{
    /// <summary>
    /// Query options for the CSR Parser API
    /// </summary>
    public class CSRParserQueryOptions
    {
        /// <summary>
        /// The PEM-formatted Certificate Signing Request to parse
        /// </summary>
        [JsonProperty("csr")]
        public string Csr { get; set; }
    }
}
