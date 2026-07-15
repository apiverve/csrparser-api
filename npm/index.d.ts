declare module '@apiverve/csrparser' {
  export interface csrparserOptions {
    api_key: string;
    secure?: boolean;
  }

  /**
   * Describes fields the current plan does not unlock. Locked fields arrive as null
   * in `data`; `locked_fields` names them, using dot paths for nested fields.
   * Absent when the plan unlocks everything.
   */
  export interface PremiumInfo {
    message: string;
    upgrade_url: string;
    locked_fields: string[];
  }

  export interface csrparserResponse {
    status: string;
    error: string | null;
    data: CSRParserData;
    code?: number;
    premium?: PremiumInfo;
  }


  interface CSRParserData {
      version:            null | string;
      subject:            Subject;
      publicKey:          PublicKey;
      signatureAlgorithm: null | string;
      extensions:         any[];
      fingerprints:       Fingerprints;
      pem:                null | string;
      sizeBytes:          number | null;
      format:             null | string;
      isValid:            boolean | null;
      securityAssessment: SecurityAssessment;
  }
  
  interface Fingerprints {
      sha1:   null | string;
      sha256: null | string;
      md5:    null | string;
  }
  
  interface PublicKey {
      algorithm: null | string;
      sizeBits:  number | null;
      exponent:  number | null;
  }
  
  interface SecurityAssessment {
      isWeakKey:             boolean | null;
      isDeprecatedSignature: boolean | null;
      keyStrength:           null | string;
  }
  
  interface Subject {
      commonName:         null | string;
      organization:       null | string;
      organizationalUnit: null | string;
      locality:           null | string;
      state:              null | string;
      country:            null | string;
      email:              null | string;
  }

  export default class csrparserWrapper {
    constructor(options: csrparserOptions);

    execute(callback: (error: any, data: csrparserResponse | null) => void): Promise<csrparserResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: csrparserResponse | null) => void): Promise<csrparserResponse>;
    execute(query?: Record<string, any>): Promise<csrparserResponse>;
  }
}
