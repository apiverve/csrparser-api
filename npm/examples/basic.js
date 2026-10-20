/**
 * Basic Example - CSR Parser API
 *
 * This example demonstrates how to use the CSR Parser API.
 * Make sure to set your API key in the .env file or replace '[YOUR_API_KEY]' below.
 */

require('dotenv').config();
const csrparserAPI = require('../index.js');

// Initialize the API client
const api = new csrparserAPI({
    api_key: process.env.API_KEY || '[YOUR_API_KEY]'
});

// Example query
var query = {
  "csr": "-----BEGIN CERTIFICATE REQUEST-----\nMIICvDCCAaQCAQAwdzELMAkGA1UEBhMCVVMxEzARBgNVBAgMCkNhbGlmb3JuaWEx\nFjAUBgNVBAcMDVNhbiBGcmFuY2lzY28xEzARBgNVBAoMCkV4YW1wbGUgQ28xEDAO\nBgNVBAsMB0RldlRlYW0xFDASBgNVBAMMC2V4YW1wbGUuY29tMIIBIjANBgkqhkiG\n9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjd/RepiCLQ5/HfKynijcPdiwygrSgxQeTKPo\nT/WiEaRTaUToW9uDUeiIHK83Tgn2+TIONpMoLJRNG+zslpHybWhVVWNlamkrlRwP\nXFQJzsxDN5+TQugILatLsp680SgMNyyPtDIpT3niiNuQ4NFepQLvQTbjXgj1celb\nU86CCeJzYengTF0ZE9Ra+/SsRTA+oy0fNLChNMc2DBaybccxwV2rNWvlvPdhfB7M\nsel3sw/x2hsbWoYC/kudzYmoDPZKX+XOhCkFwUgwib8V4hbjVLcOYsPBJcROYpRh\n9d5g7xdRlbF1I7dHsCRKnsvkIONtwKQmJ2v/UPqYahjtm2TPUQIDAQABoAAwDQYJ\nKoZIhvcNAQELBQADggEBAFEHOsN2SkB3qFBMk9JR5IDoh8rSUKj/310DOwilOQm+\n5lAwRfcFMYCl9yf4IV+XPPfvT3ahzUFfi8Fc98CDeIxAhEwtuZFlE7LA5+/F4HXM\nH3gzqTFwOZq+Wa2m029/BvcyII830h4Z+gU68R52px7O7wYSbAR/n7t1fh2bxzmW\nKqqjrvCpHoMVpgcm9y2bYTj+HLxgX4/uADFvotQppOWZi0ctam+if3Kqb3Kd2MFD\nvVHZp9NwEoqNPxmFEzcyOk2y1PYhhRja7rjdC6bdAqj6JRt+WSzStvgx7aEsxBQj\nrJCMi+GypGf9xQUfCJBhTDQVQ3fmCKTfddDeeVbJBrA=\n-----END CERTIFICATE REQUEST-----"
};

// Make the API request using callback
console.log('Making request to CSR Parser API...\n');

api.execute(query, function (error, data) {
    if (error) {
        console.error('Error occurred:');
        if (error.error) {
            console.error('Message:', error.error);
            console.error('Status:', error.status);
        } else {
            console.error(JSON.stringify(error, null, 2));
        }
        return;
    }

    console.log('Response:');
    console.log(JSON.stringify(data, null, 2));
});
