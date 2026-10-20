CSR Parser API
============

CSR Parser extracts and analyzes information from Certificate Signing Requests (CSRs), providing detailed subject information, public key details, and fingerprints.


[![PyPI version](https://img.shields.io/pypi/v/apiverve-csrparser.svg)](https://pypi.org/project/apiverve-csrparser/)

This is a Python wrapper for the [CSR Parser API](https://apiverve.com/marketplace/csrparser?utm_source=pypi&utm_medium=referral&utm_content=readme)

---

## Installation

Using `pip`:

```bash
pip install apiverve-csrparser
```

Using `pip3`:

```bash
pip3 install apiverve-csrparser
```

---

## Configuration

Before using the CSR Parser API client, you have to setup your account and obtain your API Key.
You can get it by signing up at [https://apiverve.com](https://apiverve.com?utm_source=pypi&utm_medium=referral&utm_content=readme)

---

## Quick Start

Here's a simple example to get you started quickly:

```python
from apiverve_csrparser.apiClient import CsrparserAPIClient

# Initialize the client with your APIVerve API key
api = CsrparserAPIClient("[YOUR_API_KEY]")

query = { "csr": "-----BEGIN CERTIFICATE REQUEST-----
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
-----END CERTIFICATE REQUEST-----" }

try:
    # Make the API call
    result = api.execute(query)

    # Print the result
    print(result)
except Exception as e:
    print(f"Error: {e}")
```

---

## Usage

The CSR Parser API documentation is found here: [https://docs.apiverve.com/ref/csrparser](https://docs.apiverve.com/ref/csrparser?utm_source=pypi&utm_medium=referral&utm_content=readme).
You can find parameters, example responses, and status codes documented here.

### Setup

```python
# Import the client module
from apiverve_csrparser.apiClient import CsrparserAPIClient

# Initialize the client with your APIVerve API key
api = CsrparserAPIClient("[YOUR_API_KEY]")
```

---

## Perform Request

Using the API client, you can perform requests to the API.

###### Define Query

```python
query = { "csr": "-----BEGIN CERTIFICATE REQUEST-----
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
-----END CERTIFICATE REQUEST-----" }
```

###### Simple Request

```python
# Make a request to the API
result = api.execute(query)

# Print the result
print(result)
```

###### Example Response

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

---

## Error Handling

The API client provides comprehensive error handling through the `CsrparserAPIClientError` exception. Here are some examples:

### Basic Error Handling

```python
from apiverve_csrparser.apiClient import CsrparserAPIClient, CsrparserAPIClientError

api = CsrparserAPIClient("[YOUR_API_KEY]")

query = { "csr": "-----BEGIN CERTIFICATE REQUEST-----
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
-----END CERTIFICATE REQUEST-----" }

try:
    result = api.execute(query)
    print("Success!")
    print(result)
except CsrparserAPIClientError as e:
    print(f"API Error: {e.message}")
    if e.status_code:
        print(f"Status Code: {e.status_code}")
    if e.response:
        print(f"Response: {e.response}")
```

### Handling Specific Error Types

```python
from apiverve_csrparser.apiClient import CsrparserAPIClient, CsrparserAPIClientError

api = CsrparserAPIClient("[YOUR_API_KEY]")

query = { "csr": "-----BEGIN CERTIFICATE REQUEST-----
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
-----END CERTIFICATE REQUEST-----" }

try:
    result = api.execute(query)

    # Check for successful response
    if result.get('status') == 'success':
        print("Request successful!")
        print(result.get('data'))
    else:
        print(f"API returned an error: {result.get('error')}")

except CsrparserAPIClientError as e:
    # Handle API client errors
    if e.status_code == 401:
        print("Unauthorized: Invalid API key")
    elif e.status_code == 429:
        print("Rate limit exceeded")
    elif e.status_code >= 500:
        print("Server error - please try again later")
    else:
        print(f"API error: {e.message}")
except Exception as e:
    # Handle unexpected errors
    print(f"Unexpected error: {str(e)}")
```

### Using Context Manager (Recommended)

The client supports the context manager protocol for automatic resource cleanup:

```python
from apiverve_csrparser.apiClient import CsrparserAPIClient, CsrparserAPIClientError

query = { "csr": "-----BEGIN CERTIFICATE REQUEST-----
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
-----END CERTIFICATE REQUEST-----" }

# Using context manager ensures proper cleanup
with CsrparserAPIClient("[YOUR_API_KEY]") as api:
    try:
        result = api.execute(query)
        print(result)
    except CsrparserAPIClientError as e:
        print(f"Error: {e.message}")
# Session is automatically closed here
```

---

## Advanced Features

### Debug Mode

Enable debug logging to see detailed request and response information:

```python
from apiverve_csrparser.apiClient import CsrparserAPIClient

# Enable debug mode
api = CsrparserAPIClient("[YOUR_API_KEY]", debug=True)

query = { "csr": "-----BEGIN CERTIFICATE REQUEST-----
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
-----END CERTIFICATE REQUEST-----" }

# Debug information will be printed to console
result = api.execute(query)
```

### Manual Session Management

If you need to manually manage the session lifecycle:

```python
from apiverve_csrparser.apiClient import CsrparserAPIClient

api = CsrparserAPIClient("[YOUR_API_KEY]")

query = { "csr": "-----BEGIN CERTIFICATE REQUEST-----
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
-----END CERTIFICATE REQUEST-----" }

try:
    result = api.execute(query)
    print(result)
finally:
    # Manually close the session when done
    api.close()
```

---

## Customer Support

Need any assistance? [Get in touch with Customer Support](https://apiverve.com/contact?utm_source=pypi&utm_medium=referral&utm_content=readme).

---

## Updates
Stay up to date by following [@apiverveHQ](https://twitter.com/apiverveHQ) on Twitter.

---

## Legal

All usage of the APIVerve website, API, and services is subject to the [APIVerve Terms of Service](https://apiverve.com/terms?utm_source=pypi&utm_medium=referral&utm_content=readme) and all legal documents and agreements.

---

## License
Licensed under the MIT License (MIT)

Copyright (&copy;) 2026 APIVerve, and EvlarSoft LLC

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
