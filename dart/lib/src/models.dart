/// Response models for the CSR Parser API.

/// API Response wrapper.
class CsrparserResponse {
  final String status;
  final dynamic error;
  final CsrparserData? data;

  /// Set only when the current plan locks one or more fields; null otherwise.
  final PremiumInfo? premium;

  CsrparserResponse({
    required this.status,
    this.error,
    this.data,
    this.premium,
  });

  factory CsrparserResponse.fromJson(Map<String, dynamic> json) => CsrparserResponse(
    status: json['status'] as String? ?? '',
    error: json['error'],
    data: json['data'] != null ? CsrparserData.fromJson(json['data']) : null,
    premium: json['premium'] != null ? PremiumInfo.fromJson(json['premium']) : null,
  );

  Map<String, dynamic> toJson() => {
    'status': status,
    if (error != null) 'error': error,
    if (data != null) 'data': data,
    if (premium != null) 'premium': premium!.toJson(),
  };
}

/// Describes fields the current plan does not unlock. Locked fields arrive as null
/// in [data], and [lockedFields] names them (nested ones use dot paths).
class PremiumInfo {
  final String? message;
  final String? upgradeUrl;
  final List<String>? lockedFields;

  PremiumInfo({this.message, this.upgradeUrl, this.lockedFields});

  factory PremiumInfo.fromJson(Map<String, dynamic> json) => PremiumInfo(
    message: json['message'] as String?,
    upgradeUrl: json['upgrade_url'] as String?,
    lockedFields: (json['locked_fields'] as List?)?.map((e) => e.toString()).toList(),
  );

  Map<String, dynamic> toJson() => {
    if (message != null) 'message': message,
    if (upgradeUrl != null) 'upgrade_url': upgradeUrl,
    if (lockedFields != null) 'locked_fields': lockedFields,
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
  num? sizeBytes;
  String? format;
  bool? isValid;
  CsrparserDataSecurityAssessment? securityAssessment;

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
    this.securityAssessment,
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
      securityAssessment: json['security_assessment'] != null ? CsrparserDataSecurityAssessment.fromJson(json['security_assessment']) : null,
    );
}

class CsrparserDataSubject {
  String? commonName;
  String? organization;
  String? organizationalUnit;
  String? locality;
  String? state;
  String? country;
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
  num? sizeBits;
  num? exponent;

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

class CsrparserDataSecurityAssessment {
  bool? isWeakKey;
  bool? isDeprecatedSignature;
  String? keyStrength;

  CsrparserDataSecurityAssessment({
    this.isWeakKey,
    this.isDeprecatedSignature,
    this.keyStrength,
  });

  factory CsrparserDataSecurityAssessment.fromJson(Map<String, dynamic> json) => CsrparserDataSecurityAssessment(
      isWeakKey: json['is_weak_key'],
      isDeprecatedSignature: json['is_deprecated_signature'],
      keyStrength: json['key_strength'],
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
