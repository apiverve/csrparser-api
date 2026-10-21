# CSR Parser API - Ruby Gem

CSR Parser extracts and analyzes information from Certificate Signing Requests (CSRs), providing detailed subject information, public key details, and fingerprints.

## Installation

Add this line to your application's Gemfile:

```ruby
gem 'apiverve_csrparser'
```

And then execute:

```bash
$ bundle install
```

Or install it yourself as:

```bash
$ gem install apiverve_csrparser
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```ruby
require 'apiverve_csrparser'

# Initialize the client
client = APIVerve::Csrparser::Client.new(api_key: "YOUR_API_KEY")

# Make a request
response = client.execute({ csr: "-----BEGIN CERTIFICATE REQUEST-----
MIICvDCCAaQCAQAwdzELMAkGA1UEBhMCVVMxEzARBgNVBAgMCkNhbGlmb3JuaWEx
FjAUBgNVBAcMDVNhbiBGcmFuY2lzY28xEzARBgNVBAoMCkV4YW1wbGUgQ28xEDAO
BgNVBAsMB0RldlRlYW0xFDASBgNVBAMMC2V4YW1wbGUuY29tMIIBIjANBgkqhkiG
9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjd/RepiCLQ5/HfKynijcPdiwygrSgxQeTKPo
T/WiEaRTaUToW9uDUeiIHK83Tgn2+TIONpMoLJRNG+zslpHybWhVVWNlamkrlRwP
XFQJzsxDN5+TQugILatLsp680SgMNyyPtDIpT3niiNuQ4NFepQLvQTbjXgj1celb
U86CCeJzYengTF0ZE9Ra+/SsRTA+oy0fNLChNMc2DBaybccxwV2rNWvlvPdhfB7M
sel3sw/x2hsbWoYC/kudzYmoDPZKX+XOhCkFwUgwib8V4hbjVLcOYsPBJcROYpRh
9d5g7xdRlbF1I7dHsCRKnsvkIONtwKQmJ2v/UPqYahjtm2TPUQIDAQABoAAwDQYJ
KoZIhvcNAQELBQADggEBAFEHOsN2SkB3qFBMk9JR5IDoh8rSUKj/310DOwilOQm+
5lAwRfcFMYCl9yf4IV+XPPfvT3ahzUFfi8Fc98CDeIxAhEwtuZFlE7LA5+/F4HXM
H3gzqTFwOZq+Wa2m029/BvcyII830h4Z+gU68R52px7O7wYSbAR/n7t1fh2bxzmW
KqqjrvCpHoMVpgcm9y2bYTj+HLxgX4/uADFvotQppOWZi0ctam+if3Kqb3Kd2MFD
vVHZp9NwEoqNPxmFEzcyOk2y1PYhhRja7rjdC6bdAqj6JRt+WSzStvgx7aEsxBQj
rJCMi+GypGf9xQUfCJBhTDQVQ3fmCKTfddDeeVbJBrA=
-----END CERTIFICATE REQUEST-----" })

# Print the response
puts response
```


### Error Handling

```ruby
begin
  response = client.execute({ csr: "-----BEGIN CERTIFICATE REQUEST-----
MIICvDCCAaQCAQAwdzELMAkGA1UEBhMCVVMxEzARBgNVBAgMCkNhbGlmb3JuaWEx
FjAUBgNVBAcMDVNhbiBGcmFuY2lzY28xEzARBgNVBAoMCkV4YW1wbGUgQ28xEDAO
BgNVBAsMB0RldlRlYW0xFDASBgNVBAMMC2V4YW1wbGUuY29tMIIBIjANBgkqhkiG
9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjd/RepiCLQ5/HfKynijcPdiwygrSgxQeTKPo
T/WiEaRTaUToW9uDUeiIHK83Tgn2+TIONpMoLJRNG+zslpHybWhVVWNlamkrlRwP
XFQJzsxDN5+TQugILatLsp680SgMNyyPtDIpT3niiNuQ4NFepQLvQTbjXgj1celb
U86CCeJzYengTF0ZE9Ra+/SsRTA+oy0fNLChNMc2DBaybccxwV2rNWvlvPdhfB7M
sel3sw/x2hsbWoYC/kudzYmoDPZKX+XOhCkFwUgwib8V4hbjVLcOYsPBJcROYpRh
9d5g7xdRlbF1I7dHsCRKnsvkIONtwKQmJ2v/UPqYahjtm2TPUQIDAQABoAAwDQYJ
KoZIhvcNAQELBQADggEBAFEHOsN2SkB3qFBMk9JR5IDoh8rSUKj/310DOwilOQm+
5lAwRfcFMYCl9yf4IV+XPPfvT3ahzUFfi8Fc98CDeIxAhEwtuZFlE7LA5+/F4HXM
H3gzqTFwOZq+Wa2m029/BvcyII830h4Z+gU68R52px7O7wYSbAR/n7t1fh2bxzmW
KqqjrvCpHoMVpgcm9y2bYTj+HLxgX4/uADFvotQppOWZi0ctam+if3Kqb3Kd2MFD
vVHZp9NwEoqNPxmFEzcyOk2y1PYhhRja7rjdC6bdAqj6JRt+WSzStvgx7aEsxBQj
rJCMi+GypGf9xQUfCJBhTDQVQ3fmCKTfddDeeVbJBrA=
-----END CERTIFICATE REQUEST-----" })
  puts response["data"]
rescue APIVerve::Csrparser::ValidationError => e
  puts "Validation error: #{e.errors.join(', ')}"
rescue APIVerve::Csrparser::APIError => e
  puts "API error: #{e.message}"
  puts "Status code: #{e.status_code}"
end
```

### Debug Mode

```ruby
# Enable debug logging
client = APIVerve::Csrparser::Client.new(
  api_key: "YOUR_API_KEY",
  debug: true
)
```

## Example Response

```json
{
  "status": "ok",
  "error": null,
  "data": {
    "version": "v1",
    "subject": {
      "common_name": "example.com",
      "organization": "Example Co",
      "organizational_unit": "DevTeam",
      "locality": "San Francisco",
      "state": "California",
      "country": "US",
      "email": null
    },
    "public_key": {
      "algorithm": "RSA",
      "size_bits": 2048,
      "exponent": 65537
    },
    "signature_algorithm": "SHA256withRSA",
    "extensions": [],
    "fingerprints": {
      "sha1": "05:E5:65:28:8A:47:01:D3:05:EA:3B:3F:F5:DC:C7:42:BF:06:E2:5F",
      "sha256": "E0:0B:C1:59:A3:9E:F9:96:13:7B:CE:98:BC:8F:A1:49:62:4D:2E:CF:85:D5:36:2C:DD:46:9E:96:CF:92:A3:AF",
      "md5": "27:C7:EC:94:73:34:E3:B7:3F:F6:FD:3E:0A:81:EA:3D"
    },
    "pem": "-----BEGIN CERTIFICATE REQUEST-----\nMIICvDCCAaQCAQAwdzELMAkGA1UEBhMCVVMxEzARBgNVBAgMCkNhbGlmb3JuaWEx\nFjAUBgNVBAcMDVNhbiBGcmFuY2lzY28xEzARBgNVBAoMCkV4YW1wbGUgQ28xEDAO\nBgNVBAsMB0RldlRlYW0xFDASBgNVBAMMC2V4YW1wbGUuY29tMIIBIjANBgkqhkiG\n9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjd/RepiCLQ5/HfKynijcPdiwygrSgxQeTKPo\nT/WiEaRTaUToW9uDUeiIHK83Tgn2+TIONpMoLJRNG+zslpHybWhVVWNlamkrlRwP\nXFQJzsxDN5+TQugILatLsp680SgMNyyPtDIpT3niiNuQ4NFepQLvQTbjXgj1celb\nU86CCeJzYengTF0ZE9Ra+/SsRTA+oy0fNLChNMc2DBaybccxwV2rNWvlvPdhfB7M\nsel3sw/x2hsbWoYC/kudzYmoDPZKX+XOhCkFwUgwib8V4hbjVLcOYsPBJcROYpRh\n9d5g7xdRlbF1I7dHsCRKnsvkIONtwKQmJ2v/UPqYahjtm2TPUQIDAQABoAAwDQYJ\nKoZIhvcNAQELBQADggEBAFEHOsN2SkB3qFBMk9JR5IDoh8rSUKj/310DOwilOQm+\n5lAwRfcFMYCl9yf4IV+XPPfvT3ahzUFfi8Fc98CDeIxAhEwtuZFlE7LA5+/F4HXM\nH3gzqTFwOZq+Wa2m029/BvcyII830h4Z+gU68R52px7O7wYSbAR/n7t1fh2bxzmW\nKqqjrvCpHoMVpgcm9y2bYTj+HLxgX4/uADFvotQppOWZi0ctam+if3Kqb3Kd2MFD\nvVHZp9NwEoqNPxmFEzcyOk2y1PYhhRja7rjdC6bdAqj6JRt+WSzStvgx7aEsxBQj\nrJCMi+GypGf9xQUfCJBhTDQVQ3fmCKTfddDeeVbJBrA=\n-----END CERTIFICATE REQUEST-----",
    "size_bytes": 704,
    "format": "PEM",
    "is_valid": true,
    "security_assessment": {
      "is_weak_key": false,
      "is_deprecated_signature": false,
      "key_strength": "acceptable"
    }
  }
}
```

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/csrparser?utm_source=rubygems&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/csrparser?utm_source=ruby&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/csrparser?utm_source=ruby&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This gem is available under the [MIT License](LICENSE).
