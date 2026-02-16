# CSR Parser API - Dart/Flutter Client

CSR Parser extracts and analyzes information from Certificate Signing Requests (CSRs), providing detailed subject information, public key details, and fingerprints.

[![pub package](https://img.shields.io/pub/v/apiverve_csrparser.svg)](https://pub.dev/packages/apiverve_csrparser)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

This is the Dart/Flutter client for the [CSR Parser API](https://apiverve.com/marketplace/csrparser?utm_source=dart&utm_medium=readme).

## Installation

Add this to your `pubspec.yaml`:

```yaml
dependencies:
  apiverve_csrparser: ^1.1.14
```

Then run:

```bash
dart pub get
# or for Flutter
flutter pub get
```

## Usage

```dart
import 'package:apiverve_csrparser/apiverve_csrparser.dart';

void main() async {
  final client = CsrparserClient('YOUR_API_KEY');

  try {
    final response = await client.execute({
      'csr': '-----BEGIN CERTIFICATE REQUEST-----
MIICvDCCAaQCAQAwdzELMAkGA1UEBhMCVVMxEzARBgNVBAgMCkNhbGlmb3JuaWEx
FjAUBgNVBAcMDVNhbiBGcmFuY2lzY28xEzARBgNVBAoMCkV4YW1wbGUgQ28xEDAO
BgNVBAsMB0RldlRlYW0xFDASBgNVBAMMC2V4YW1wbGUuY29tMIIBIjANBgkqhkiG
9w0BAQEFAAOCAQ8AMIIBCgKCAQEAuqKT3qPzGqKqV3LqR2r3XqKqKqKqKqKqKqKq
KqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKq
KqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKq
KqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKq
KqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKq
KqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKq
KwIDAQABoAAwDQYJKoZIhvcNAQELBQADggEBAH4jI5yKqKqKqKqKqKqKqKqKqKqK
qKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqK
qKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqK
qKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqK
qKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqK
qKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqK
-----END CERTIFICATE REQUEST-----'
    });

    print('Status: ${response.status}');
    print('Data: ${response.data}');
  } catch (e) {
    print('Error: $e');
  }
}
```

## Response

```json
{
  "status": "ok",
  "error": null,
  "data": {
    "version": "v1",
    "subject": {
      "common_name": null,
      "organization": null,
      "organizational_unit": null,
      "locality": null,
      "state": null,
      "country": null,
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
      "sha1": "82:D3:E3:9A:FB:85:22:65:16:84:43:2F:BB:05:35:2A:95:37:BF:58",
      "sha256": "D8:73:E8:A3:DE:22:57:D6:AD:A0:AD:AB:53:75:FB:09:07:79:4D:21:CF:F1:0A:C0:55:EF:4B:67:A0:20:FE:9D",
      "md5": "4A:AC:A6:9D:40:6C:2F:34:51:D3:A7:7E:06:23:66:0A"
    },
    "pem": "-----BEGIN CERTIFICATE REQUEST-----\nMIICvDCCAaQCAQAwdzELMAkGA1UEBhMCVVMxEzARBgNVBAgMCkNhbGlmb3JuaWEx\nFjAUBgNVBAcMDVNhbiBGcmFuY2lzY28xEzARBgNVBAoMCkV4YW1wbGUgQ28xEDAO\nBgNVBAsMB0RldlRlYW0xFDASBgNVBAMMC2V4YW1wbGUuY29tMIIBIjANBgkqhkiG\n9w0BAQEFAAOCAQ8AMIIBCgKCAQEAuqKT3qPzGqKqV3LqR2r3XqKqKqKqKqKqKqKq\nKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKq\nKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKq\nKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKq\nKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKq\nKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKq\nKwIDAQABoAAwDQYJKoZIhvcNAQELBQADggEBAH4jI5yKqKqKqKqKqKqKqKqKqKqK\nqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqK\nqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqK\nqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqK\nqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqK\nqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqKqK\n-----END CERTIFICATE REQUEST-----",
    "size_bytes": 705,
    "format": "PEM",
    "is_valid": true
  }
}
```

## API Reference

- **API Home:** [CSR Parser API](https://apiverve.com/marketplace/csrparser?utm_source=dart&utm_medium=readme)
- **Documentation:** [docs.apiverve.com/ref/csrparser](https://docs.apiverve.com/ref/csrparser?utm_source=dart&utm_medium=readme)

## Authentication

All requests require an API key. Get yours at [apiverve.com](https://apiverve.com?utm_source=dart&utm_medium=readme).

## License

MIT License - see [LICENSE](LICENSE) for details.

---

Built with Dart for [APIVerve](https://apiverve.com?utm_source=dart&utm_medium=readme)
