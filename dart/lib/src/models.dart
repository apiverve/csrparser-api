/// Response models for the CSR Parser API.

/// API Response wrapper.
class CsrparserResponse {
  final String status;
  final dynamic error;
  final CsrparserData? data;

  CsrparserResponse({
    required this.status,
    this.error,
    this.data,
  });

  factory CsrparserResponse.fromJson(Map<String, dynamic> json) => CsrparserResponse(
    status: json['status'] as String? ?? '',
    error: json['error'],
    data: json['data'] != null ? CsrparserData.fromJson(json['data']) : null,
  );

  Map<String, dynamic> toJson() => {
    'status': status,
    if (error != null) 'error': error,
    if (data != null) 'data': data,
  };
}

/// Response data for the CSR Parser API.

class CsrparserData {
  String? version;
  CsrparserDataSubject? subject;
  CsrparserDataPublicKey? publicKey;
  String? signatureAlgorithm;
  List<dynamic>? extensions;
  CsrparserDataFingerprints? fingerprints;
  String? pem;
  int? sizeBytes;
  String? format;
  bool? isValid;

  CsrparserData({
    this.version,
    this.subject,
    this.publicKey,
    this.signatureAlgorithm,
    this.extensions,
    this.fingerprints,
    this.pem,
    this.sizeBytes,
    this.format,
    this.isValid,
  });

  factory CsrparserData.fromJson(Map<String, dynamic> json) => CsrparserData(
      version: json['version'],
      subject: json['subject'] != null ? CsrparserDataSubject.fromJson(json['subject']) : null,
      publicKey: json['public_key'] != null ? CsrparserDataPublicKey.fromJson(json['public_key']) : null,
      signatureAlgorithm: json['signature_algorithm'],
      extensions: (json['extensions'] as List?)?.cast<dynamic>(),
      fingerprints: json['fingerprints'] != null ? CsrparserDataFingerprints.fromJson(json['fingerprints']) : null,
      pem: json['pem'],
      sizeBytes: json['size_bytes'],
      format: json['format'],
      isValid: json['is_valid'],
    );
}

class CsrparserDataSubject {
  dynamic commonName;
  dynamic organization;
  dynamic organizationalUnit;
  dynamic locality;
  dynamic state;
  dynamic country;
  dynamic email;

  CsrparserDataSubject({
    this.commonName,
    this.organization,
    this.organizationalUnit,
    this.locality,
    this.state,
    this.country,
    this.email,
  });

  factory CsrparserDataSubject.fromJson(Map<String, dynamic> json) => CsrparserDataSubject(
      commonName: json['common_name'],
      organization: json['organization'],
      organizationalUnit: json['organizational_unit'],
      locality: json['locality'],
      state: json['state'],
      country: json['country'],
      email: json['email'],
    );
}

class CsrparserDataPublicKey {
  String? algorithm;
  int? sizeBits;
  int? exponent;

  CsrparserDataPublicKey({
    this.algorithm,
    this.sizeBits,
    this.exponent,
  });

  factory CsrparserDataPublicKey.fromJson(Map<String, dynamic> json) => CsrparserDataPublicKey(
      algorithm: json['algorithm'],
      sizeBits: json['size_bits'],
      exponent: json['exponent'],
    );
}

class CsrparserDataFingerprints {
  String? sha1;
  String? sha256;
  String? md5;

  CsrparserDataFingerprints({
    this.sha1,
    this.sha256,
    this.md5,
  });

  factory CsrparserDataFingerprints.fromJson(Map<String, dynamic> json) => CsrparserDataFingerprints(
      sha1: json['sha1'],
      sha256: json['sha256'],
      md5: json['md5'],
    );
}

class CsrparserRequest {
  String csr;

  CsrparserRequest({
    required this.csr,
  });

  Map<String, dynamic> toJson() => {
      'csr': csr,
    };
}
