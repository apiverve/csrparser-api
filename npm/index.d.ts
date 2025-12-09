declare module '@apiverve/csrparser' {
  export interface csrparserOptions {
    api_key: string;
    secure?: boolean;
  }

  export interface csrparserResponse {
    status: string;
    error: string | null;
    data: CSRParserData;
    code?: number;
  }


  interface CSRParserData {
      version:            string;
      subject:            Subject;
      publicKey:          PublicKey;
      signatureAlgorithm: string;
      extensions:         any[];
      fingerprints:       Fingerprints;
      pem:                string;
      sizeBytes:          number;
      format:             string;
      isValid:            boolean;
  }
  
  interface Fingerprints {
      sha1:   string;
      sha256: string;
      md5:    string;
  }
  
  interface PublicKey {
      algorithm: string;
      sizeBits:  number;
      exponent:  number;
  }
  
  interface Subject {
      commonName:         null;
      organization:       null;
      organizationalUnit: null;
      locality:           null;
      state:              null;
      country:            null;
      email:              null;
  }

  export default class csrparserWrapper {
    constructor(options: csrparserOptions);

    execute(callback: (error: any, data: csrparserResponse | null) => void): Promise<csrparserResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: csrparserResponse | null) => void): Promise<csrparserResponse>;
    execute(query?: Record<string, any>): Promise<csrparserResponse>;
  }
}
