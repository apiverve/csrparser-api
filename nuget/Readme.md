CSR Parser API
============

CSR Parser extracts and analyzes information from Certificate Signing Requests (CSRs), providing detailed subject information, public key details, and fingerprints.


[![NuGet version](https://img.shields.io/nuget/v/APIVerve.API.CSRParser.svg)](https://www.nuget.org/packages/APIVerve.API.CSRParser)

This is a .NET wrapper for the [CSR Parser API](https://apiverve.com/marketplace/csrparser?utm_source=nuget&utm_medium=referral&utm_content=readme)

---

## Installation

Using the .NET CLI:
```
dotnet add package APIVerve.API.CSRParser
```

Using the Package Manager:
```
nuget install APIVerve.API.CSRParser
```

Using the Package Manager Console:
```
Install-Package APIVerve.API.CSRParser
```

From within Visual Studio:

1. Open the Solution Explorer
2. Right-click on a project within your solution
3. Click on Manage NuGet Packages
4. Click on the Browse tab and search for "APIVerve.API.CSRParser"
5. Click on the APIVerve.API.CSRParser package, select the appropriate version in the right-tab and click Install

---

## Configuration

Before using the CSR Parser API client, you have to setup your account and obtain your API Key.
You can get it by signing up at [https://apiverve.com](https://apiverve.com?utm_source=nuget&utm_medium=referral&utm_content=readme)

---

## Quick Start

Here's a simple example to get you started quickly:

```csharp
using System;
using APIVerve.API.CSRParser;

class Program
{
    static async Task Main(string[] args)
    {
        // Initialize the API client
        var apiClient = new CSRParserAPIClient("[YOUR_API_KEY]");

        var queryOptions = new CSRParserQueryOptions {
            Csr = "-----BEGIN CERTIFICATE REQUEST-----\nMIICvDCCAaQCAQAwdzELMAkGA1UEBhMCVVMxEzARBgNVBAgMCkNhbGlmb3JuaWEx\nFjAUBgNVBAcMDVNhbiBGcmFuY2lzY28xEzARBgNVBAoMCkV4YW1wbGUgQ28xEDAO\nBgNVBAsMB0RldlRlYW0xFDASBgNVBAMMC2V4YW1wbGUuY29tMIIBIjANBgkqhkiG\n9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjd/RepiCLQ5/HfKynijcPdiwygrSgxQeTKPo\nT/WiEaRTaUToW9uDUeiIHK83Tgn2+TIONpMoLJRNG+zslpHybWhVVWNlamkrlRwP\nXFQJzsxDN5+TQugILatLsp680SgMNyyPtDIpT3niiNuQ4NFepQLvQTbjXgj1celb\nU86CCeJzYengTF0ZE9Ra+/SsRTA+oy0fNLChNMc2DBaybccxwV2rNWvlvPdhfB7M\nsel3sw/x2hsbWoYC/kudzYmoDPZKX+XOhCkFwUgwib8V4hbjVLcOYsPBJcROYpRh\n9d5g7xdRlbF1I7dHsCRKnsvkIONtwKQmJ2v/UPqYahjtm2TPUQIDAQABoAAwDQYJ\nKoZIhvcNAQELBQADggEBAFEHOsN2SkB3qFBMk9JR5IDoh8rSUKj/310DOwilOQm+\n5lAwRfcFMYCl9yf4IV+XPPfvT3ahzUFfi8Fc98CDeIxAhEwtuZFlE7LA5+/F4HXM\nH3gzqTFwOZq+Wa2m029/BvcyII830h4Z+gU68R52px7O7wYSbAR/n7t1fh2bxzmW\nKqqjrvCpHoMVpgcm9y2bYTj+HLxgX4/uADFvotQppOWZi0ctam+if3Kqb3Kd2MFD\nvVHZp9NwEoqNPxmFEzcyOk2y1PYhhRja7rjdC6bdAqj6JRt+WSzStvgx7aEsxBQj\nrJCMi+GypGf9xQUfCJBhTDQVQ3fmCKTfddDeeVbJBrA=\n-----END CERTIFICATE REQUEST-----"
        };

        // Make the API call
        try
        {
            var response = await apiClient.ExecuteAsync(queryOptions);

            if (response.Error != null)
            {
                Console.WriteLine($"API Error: {response.Error}");
            }
            else
            {
                Console.WriteLine("Success!");
                // Access response data using the strongly-typed ResponseObj properties
                Console.WriteLine(Newtonsoft.Json.JsonConvert.SerializeObject(response, Newtonsoft.Json.Formatting.Indented));
            }
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Exception: {ex.Message}");
        }
    }
}
```

---

## Usage

The CSR Parser API documentation is found here: [https://docs.apiverve.com/ref/csrparser](https://docs.apiverve.com/ref/csrparser?utm_source=nuget&utm_medium=referral&utm_content=readme).
You can find parameters, example responses, and status codes documented here.

### Setup

###### Authentication
CSR Parser API uses API Key-based authentication. When you create an instance of the API client, you can pass your API Key as a parameter.

```csharp
// Create an instance of the API client
var apiClient = new CSRParserAPIClient("[YOUR_API_KEY]");
```

---

## Usage Examples

### Basic Usage (Async/Await Pattern - Recommended)

The modern async/await pattern provides the best performance and code readability:

```csharp
using System;
using System.Threading.Tasks;
using APIVerve.API.CSRParser;

public class Example
{
    public static async Task Main(string[] args)
    {
        var apiClient = new CSRParserAPIClient("[YOUR_API_KEY]");

        var queryOptions = new CSRParserQueryOptions {
            Csr = "-----BEGIN CERTIFICATE REQUEST-----\nMIICvDCCAaQCAQAwdzELMAkGA1UEBhMCVVMxEzARBgNVBAgMCkNhbGlmb3JuaWEx\nFjAUBgNVBAcMDVNhbiBGcmFuY2lzY28xEzARBgNVBAoMCkV4YW1wbGUgQ28xEDAO\nBgNVBAsMB0RldlRlYW0xFDASBgNVBAMMC2V4YW1wbGUuY29tMIIBIjANBgkqhkiG\n9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjd/RepiCLQ5/HfKynijcPdiwygrSgxQeTKPo\nT/WiEaRTaUToW9uDUeiIHK83Tgn2+TIONpMoLJRNG+zslpHybWhVVWNlamkrlRwP\nXFQJzsxDN5+TQugILatLsp680SgMNyyPtDIpT3niiNuQ4NFepQLvQTbjXgj1celb\nU86CCeJzYengTF0ZE9Ra+/SsRTA+oy0fNLChNMc2DBaybccxwV2rNWvlvPdhfB7M\nsel3sw/x2hsbWoYC/kudzYmoDPZKX+XOhCkFwUgwib8V4hbjVLcOYsPBJcROYpRh\n9d5g7xdRlbF1I7dHsCRKnsvkIONtwKQmJ2v/UPqYahjtm2TPUQIDAQABoAAwDQYJ\nKoZIhvcNAQELBQADggEBAFEHOsN2SkB3qFBMk9JR5IDoh8rSUKj/310DOwilOQm+\n5lAwRfcFMYCl9yf4IV+XPPfvT3ahzUFfi8Fc98CDeIxAhEwtuZFlE7LA5+/F4HXM\nH3gzqTFwOZq+Wa2m029/BvcyII830h4Z+gU68R52px7O7wYSbAR/n7t1fh2bxzmW\nKqqjrvCpHoMVpgcm9y2bYTj+HLxgX4/uADFvotQppOWZi0ctam+if3Kqb3Kd2MFD\nvVHZp9NwEoqNPxmFEzcyOk2y1PYhhRja7rjdC6bdAqj6JRt+WSzStvgx7aEsxBQj\nrJCMi+GypGf9xQUfCJBhTDQVQ3fmCKTfddDeeVbJBrA=\n-----END CERTIFICATE REQUEST-----"
        };

        var response = await apiClient.ExecuteAsync(queryOptions);

        if (response.Error != null)
        {
            Console.WriteLine($"Error: {response.Error}");
        }
        else
        {
            Console.WriteLine(Newtonsoft.Json.JsonConvert.SerializeObject(response, Newtonsoft.Json.Formatting.Indented));
        }
    }
}
```

### Synchronous Usage

If you need to use synchronous code, you can use the `Execute` method:

```csharp
using System;
using APIVerve.API.CSRParser;

public class Example
{
    public static void Main(string[] args)
    {
        var apiClient = new CSRParserAPIClient("[YOUR_API_KEY]");

        var queryOptions = new CSRParserQueryOptions {
            Csr = "-----BEGIN CERTIFICATE REQUEST-----\nMIICvDCCAaQCAQAwdzELMAkGA1UEBhMCVVMxEzARBgNVBAgMCkNhbGlmb3JuaWEx\nFjAUBgNVBAcMDVNhbiBGcmFuY2lzY28xEzARBgNVBAoMCkV4YW1wbGUgQ28xEDAO\nBgNVBAsMB0RldlRlYW0xFDASBgNVBAMMC2V4YW1wbGUuY29tMIIBIjANBgkqhkiG\n9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjd/RepiCLQ5/HfKynijcPdiwygrSgxQeTKPo\nT/WiEaRTaUToW9uDUeiIHK83Tgn2+TIONpMoLJRNG+zslpHybWhVVWNlamkrlRwP\nXFQJzsxDN5+TQugILatLsp680SgMNyyPtDIpT3niiNuQ4NFepQLvQTbjXgj1celb\nU86CCeJzYengTF0ZE9Ra+/SsRTA+oy0fNLChNMc2DBaybccxwV2rNWvlvPdhfB7M\nsel3sw/x2hsbWoYC/kudzYmoDPZKX+XOhCkFwUgwib8V4hbjVLcOYsPBJcROYpRh\n9d5g7xdRlbF1I7dHsCRKnsvkIONtwKQmJ2v/UPqYahjtm2TPUQIDAQABoAAwDQYJ\nKoZIhvcNAQELBQADggEBAFEHOsN2SkB3qFBMk9JR5IDoh8rSUKj/310DOwilOQm+\n5lAwRfcFMYCl9yf4IV+XPPfvT3ahzUFfi8Fc98CDeIxAhEwtuZFlE7LA5+/F4HXM\nH3gzqTFwOZq+Wa2m029/BvcyII830h4Z+gU68R52px7O7wYSbAR/n7t1fh2bxzmW\nKqqjrvCpHoMVpgcm9y2bYTj+HLxgX4/uADFvotQppOWZi0ctam+if3Kqb3Kd2MFD\nvVHZp9NwEoqNPxmFEzcyOk2y1PYhhRja7rjdC6bdAqj6JRt+WSzStvgx7aEsxBQj\nrJCMi+GypGf9xQUfCJBhTDQVQ3fmCKTfddDeeVbJBrA=\n-----END CERTIFICATE REQUEST-----"
        };

        var response = apiClient.Execute(queryOptions);

        if (response.Error != null)
        {
            Console.WriteLine($"Error: {response.Error}");
        }
        else
        {
            Console.WriteLine(Newtonsoft.Json.JsonConvert.SerializeObject(response, Newtonsoft.Json.Formatting.Indented));
        }
    }
}
```

---

## Error Handling

The API client provides comprehensive error handling. Here are some examples:

### Handling API Errors

```csharp
using System;
using System.Threading.Tasks;
using APIVerve.API.CSRParser;

public class Example
{
    public static async Task Main(string[] args)
    {
        var apiClient = new CSRParserAPIClient("[YOUR_API_KEY]");

        var queryOptions = new CSRParserQueryOptions {
            Csr = "-----BEGIN CERTIFICATE REQUEST-----\nMIICvDCCAaQCAQAwdzELMAkGA1UEBhMCVVMxEzARBgNVBAgMCkNhbGlmb3JuaWEx\nFjAUBgNVBAcMDVNhbiBGcmFuY2lzY28xEzARBgNVBAoMCkV4YW1wbGUgQ28xEDAO\nBgNVBAsMB0RldlRlYW0xFDASBgNVBAMMC2V4YW1wbGUuY29tMIIBIjANBgkqhkiG\n9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjd/RepiCLQ5/HfKynijcPdiwygrSgxQeTKPo\nT/WiEaRTaUToW9uDUeiIHK83Tgn2+TIONpMoLJRNG+zslpHybWhVVWNlamkrlRwP\nXFQJzsxDN5+TQugILatLsp680SgMNyyPtDIpT3niiNuQ4NFepQLvQTbjXgj1celb\nU86CCeJzYengTF0ZE9Ra+/SsRTA+oy0fNLChNMc2DBaybccxwV2rNWvlvPdhfB7M\nsel3sw/x2hsbWoYC/kudzYmoDPZKX+XOhCkFwUgwib8V4hbjVLcOYsPBJcROYpRh\n9d5g7xdRlbF1I7dHsCRKnsvkIONtwKQmJ2v/UPqYahjtm2TPUQIDAQABoAAwDQYJ\nKoZIhvcNAQELBQADggEBAFEHOsN2SkB3qFBMk9JR5IDoh8rSUKj/310DOwilOQm+\n5lAwRfcFMYCl9yf4IV+XPPfvT3ahzUFfi8Fc98CDeIxAhEwtuZFlE7LA5+/F4HXM\nH3gzqTFwOZq+Wa2m029/BvcyII830h4Z+gU68R52px7O7wYSbAR/n7t1fh2bxzmW\nKqqjrvCpHoMVpgcm9y2bYTj+HLxgX4/uADFvotQppOWZi0ctam+if3Kqb3Kd2MFD\nvVHZp9NwEoqNPxmFEzcyOk2y1PYhhRja7rjdC6bdAqj6JRt+WSzStvgx7aEsxBQj\nrJCMi+GypGf9xQUfCJBhTDQVQ3fmCKTfddDeeVbJBrA=\n-----END CERTIFICATE REQUEST-----"
        };

        try
        {
            var response = await apiClient.ExecuteAsync(queryOptions);

            // Check for API-level errors
            if (response.Error != null)
            {
                Console.WriteLine($"API Error: {response.Error}");
                Console.WriteLine($"Status: {response.Status}");
                return;
            }

            // Success - use the data
            Console.WriteLine("Request successful!");
            Console.WriteLine(Newtonsoft.Json.JsonConvert.SerializeObject(response, Newtonsoft.Json.Formatting.Indented));
        }
        catch (ArgumentException ex)
        {
            // Invalid API key or parameters
            Console.WriteLine($"Invalid argument: {ex.Message}");
        }
        catch (System.Net.Http.HttpRequestException ex)
        {
            // Network or HTTP errors
            Console.WriteLine($"Network error: {ex.Message}");
        }
        catch (Exception ex)
        {
            // Other errors
            Console.WriteLine($"Unexpected error: {ex.Message}");
        }
    }
}
```

### Comprehensive Error Handling with Retry Logic

```csharp
using System;
using System.Threading.Tasks;
using APIVerve.API.CSRParser;

public class Example
{
    public static async Task Main(string[] args)
    {
        var apiClient = new CSRParserAPIClient("[YOUR_API_KEY]");

        // Configure retry behavior (max 3 retries)
        apiClient.SetMaxRetries(3);        // Retry up to 3 times (default: 0, max: 3)
        apiClient.SetRetryDelay(2000);     // Wait 2 seconds between retries

        var queryOptions = new CSRParserQueryOptions {
            Csr = "-----BEGIN CERTIFICATE REQUEST-----\nMIICvDCCAaQCAQAwdzELMAkGA1UEBhMCVVMxEzARBgNVBAgMCkNhbGlmb3JuaWEx\nFjAUBgNVBAcMDVNhbiBGcmFuY2lzY28xEzARBgNVBAoMCkV4YW1wbGUgQ28xEDAO\nBgNVBAsMB0RldlRlYW0xFDASBgNVBAMMC2V4YW1wbGUuY29tMIIBIjANBgkqhkiG\n9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjd/RepiCLQ5/HfKynijcPdiwygrSgxQeTKPo\nT/WiEaRTaUToW9uDUeiIHK83Tgn2+TIONpMoLJRNG+zslpHybWhVVWNlamkrlRwP\nXFQJzsxDN5+TQugILatLsp680SgMNyyPtDIpT3niiNuQ4NFepQLvQTbjXgj1celb\nU86CCeJzYengTF0ZE9Ra+/SsRTA+oy0fNLChNMc2DBaybccxwV2rNWvlvPdhfB7M\nsel3sw/x2hsbWoYC/kudzYmoDPZKX+XOhCkFwUgwib8V4hbjVLcOYsPBJcROYpRh\n9d5g7xdRlbF1I7dHsCRKnsvkIONtwKQmJ2v/UPqYahjtm2TPUQIDAQABoAAwDQYJ\nKoZIhvcNAQELBQADggEBAFEHOsN2SkB3qFBMk9JR5IDoh8rSUKj/310DOwilOQm+\n5lAwRfcFMYCl9yf4IV+XPPfvT3ahzUFfi8Fc98CDeIxAhEwtuZFlE7LA5+/F4HXM\nH3gzqTFwOZq+Wa2m029/BvcyII830h4Z+gU68R52px7O7wYSbAR/n7t1fh2bxzmW\nKqqjrvCpHoMVpgcm9y2bYTj+HLxgX4/uADFvotQppOWZi0ctam+if3Kqb3Kd2MFD\nvVHZp9NwEoqNPxmFEzcyOk2y1PYhhRja7rjdC6bdAqj6JRt+WSzStvgx7aEsxBQj\nrJCMi+GypGf9xQUfCJBhTDQVQ3fmCKTfddDeeVbJBrA=\n-----END CERTIFICATE REQUEST-----"
        };

        try
        {
            var response = await apiClient.ExecuteAsync(queryOptions);

            if (response.Error != null)
            {
                Console.WriteLine($"API Error: {response.Error}");
            }
            else
            {
                Console.WriteLine("Success!");
                Console.WriteLine(Newtonsoft.Json.JsonConvert.SerializeObject(response, Newtonsoft.Json.Formatting.Indented));
            }
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Failed after retries: {ex.Message}");
        }
    }
}
```

---

## Advanced Features

### Custom Headers

Add custom headers to your requests:

```csharp
var apiClient = new CSRParserAPIClient("[YOUR_API_KEY]");

// Add custom headers
apiClient.AddCustomHeader("X-Custom-Header", "custom-value");
apiClient.AddCustomHeader("X-Request-ID", Guid.NewGuid().ToString());

var queryOptions = new CSRParserQueryOptions {
    Csr = "-----BEGIN CERTIFICATE REQUEST-----\nMIICvDCCAaQCAQAwdzELMAkGA1UEBhMCVVMxEzARBgNVBAgMCkNhbGlmb3JuaWEx\nFjAUBgNVBAcMDVNhbiBGcmFuY2lzY28xEzARBgNVBAoMCkV4YW1wbGUgQ28xEDAO\nBgNVBAsMB0RldlRlYW0xFDASBgNVBAMMC2V4YW1wbGUuY29tMIIBIjANBgkqhkiG\n9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjd/RepiCLQ5/HfKynijcPdiwygrSgxQeTKPo\nT/WiEaRTaUToW9uDUeiIHK83Tgn2+TIONpMoLJRNG+zslpHybWhVVWNlamkrlRwP\nXFQJzsxDN5+TQugILatLsp680SgMNyyPtDIpT3niiNuQ4NFepQLvQTbjXgj1celb\nU86CCeJzYengTF0ZE9Ra+/SsRTA+oy0fNLChNMc2DBaybccxwV2rNWvlvPdhfB7M\nsel3sw/x2hsbWoYC/kudzYmoDPZKX+XOhCkFwUgwib8V4hbjVLcOYsPBJcROYpRh\n9d5g7xdRlbF1I7dHsCRKnsvkIONtwKQmJ2v/UPqYahjtm2TPUQIDAQABoAAwDQYJ\nKoZIhvcNAQELBQADggEBAFEHOsN2SkB3qFBMk9JR5IDoh8rSUKj/310DOwilOQm+\n5lAwRfcFMYCl9yf4IV+XPPfvT3ahzUFfi8Fc98CDeIxAhEwtuZFlE7LA5+/F4HXM\nH3gzqTFwOZq+Wa2m029/BvcyII830h4Z+gU68R52px7O7wYSbAR/n7t1fh2bxzmW\nKqqjrvCpHoMVpgcm9y2bYTj+HLxgX4/uADFvotQppOWZi0ctam+if3Kqb3Kd2MFD\nvVHZp9NwEoqNPxmFEzcyOk2y1PYhhRja7rjdC6bdAqj6JRt+WSzStvgx7aEsxBQj\nrJCMi+GypGf9xQUfCJBhTDQVQ3fmCKTfddDeeVbJBrA=\n-----END CERTIFICATE REQUEST-----"
};

var response = await apiClient.ExecuteAsync(queryOptions);

// Remove a header
apiClient.RemoveCustomHeader("X-Custom-Header");

// Clear all custom headers
apiClient.ClearCustomHeaders();
```

### Request Logging

Enable logging for debugging:

```csharp
var apiClient = new CSRParserAPIClient("[YOUR_API_KEY]", isDebug: true);

// Or use a custom logger
apiClient.SetLogger(message =>
{
    Console.WriteLine($"[LOG] {DateTime.Now:yyyy-MM-dd HH:mm:ss} - {message}");
});

var queryOptions = new CSRParserQueryOptions {
    Csr = "-----BEGIN CERTIFICATE REQUEST-----\nMIICvDCCAaQCAQAwdzELMAkGA1UEBhMCVVMxEzARBgNVBAgMCkNhbGlmb3JuaWEx\nFjAUBgNVBAcMDVNhbiBGcmFuY2lzY28xEzARBgNVBAoMCkV4YW1wbGUgQ28xEDAO\nBgNVBAsMB0RldlRlYW0xFDASBgNVBAMMC2V4YW1wbGUuY29tMIIBIjANBgkqhkiG\n9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjd/RepiCLQ5/HfKynijcPdiwygrSgxQeTKPo\nT/WiEaRTaUToW9uDUeiIHK83Tgn2+TIONpMoLJRNG+zslpHybWhVVWNlamkrlRwP\nXFQJzsxDN5+TQugILatLsp680SgMNyyPtDIpT3niiNuQ4NFepQLvQTbjXgj1celb\nU86CCeJzYengTF0ZE9Ra+/SsRTA+oy0fNLChNMc2DBaybccxwV2rNWvlvPdhfB7M\nsel3sw/x2hsbWoYC/kudzYmoDPZKX+XOhCkFwUgwib8V4hbjVLcOYsPBJcROYpRh\n9d5g7xdRlbF1I7dHsCRKnsvkIONtwKQmJ2v/UPqYahjtm2TPUQIDAQABoAAwDQYJ\nKoZIhvcNAQELBQADggEBAFEHOsN2SkB3qFBMk9JR5IDoh8rSUKj/310DOwilOQm+\n5lAwRfcFMYCl9yf4IV+XPPfvT3ahzUFfi8Fc98CDeIxAhEwtuZFlE7LA5+/F4HXM\nH3gzqTFwOZq+Wa2m029/BvcyII830h4Z+gU68R52px7O7wYSbAR/n7t1fh2bxzmW\nKqqjrvCpHoMVpgcm9y2bYTj+HLxgX4/uADFvotQppOWZi0ctam+if3Kqb3Kd2MFD\nvVHZp9NwEoqNPxmFEzcyOk2y1PYhhRja7rjdC6bdAqj6JRt+WSzStvgx7aEsxBQj\nrJCMi+GypGf9xQUfCJBhTDQVQ3fmCKTfddDeeVbJBrA=\n-----END CERTIFICATE REQUEST-----"
};

var response = await apiClient.ExecuteAsync(queryOptions);
```

### Retry Configuration

Customize retry behavior for failed requests:

```csharp
var apiClient = new CSRParserAPIClient("[YOUR_API_KEY]");

// Set retry options
apiClient.SetMaxRetries(3);           // Retry up to 3 times (default: 0, max: 3)
apiClient.SetRetryDelay(1500);        // Wait 1.5 seconds between retries (default: 1000ms)

var queryOptions = new CSRParserQueryOptions {
    Csr = "-----BEGIN CERTIFICATE REQUEST-----\nMIICvDCCAaQCAQAwdzELMAkGA1UEBhMCVVMxEzARBgNVBAgMCkNhbGlmb3JuaWEx\nFjAUBgNVBAcMDVNhbiBGcmFuY2lzY28xEzARBgNVBAoMCkV4YW1wbGUgQ28xEDAO\nBgNVBAsMB0RldlRlYW0xFDASBgNVBAMMC2V4YW1wbGUuY29tMIIBIjANBgkqhkiG\n9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjd/RepiCLQ5/HfKynijcPdiwygrSgxQeTKPo\nT/WiEaRTaUToW9uDUeiIHK83Tgn2+TIONpMoLJRNG+zslpHybWhVVWNlamkrlRwP\nXFQJzsxDN5+TQugILatLsp680SgMNyyPtDIpT3niiNuQ4NFepQLvQTbjXgj1celb\nU86CCeJzYengTF0ZE9Ra+/SsRTA+oy0fNLChNMc2DBaybccxwV2rNWvlvPdhfB7M\nsel3sw/x2hsbWoYC/kudzYmoDPZKX+XOhCkFwUgwib8V4hbjVLcOYsPBJcROYpRh\n9d5g7xdRlbF1I7dHsCRKnsvkIONtwKQmJ2v/UPqYahjtm2TPUQIDAQABoAAwDQYJ\nKoZIhvcNAQELBQADggEBAFEHOsN2SkB3qFBMk9JR5IDoh8rSUKj/310DOwilOQm+\n5lAwRfcFMYCl9yf4IV+XPPfvT3ahzUFfi8Fc98CDeIxAhEwtuZFlE7LA5+/F4HXM\nH3gzqTFwOZq+Wa2m029/BvcyII830h4Z+gU68R52px7O7wYSbAR/n7t1fh2bxzmW\nKqqjrvCpHoMVpgcm9y2bYTj+HLxgX4/uADFvotQppOWZi0ctam+if3Kqb3Kd2MFD\nvVHZp9NwEoqNPxmFEzcyOk2y1PYhhRja7rjdC6bdAqj6JRt+WSzStvgx7aEsxBQj\nrJCMi+GypGf9xQUfCJBhTDQVQ3fmCKTfddDeeVbJBrA=\n-----END CERTIFICATE REQUEST-----"
};

var response = await apiClient.ExecuteAsync(queryOptions);
```

### Dispose Pattern

The API client implements `IDisposable` for proper resource cleanup:

```csharp
var queryOptions = new CSRParserQueryOptions {
    Csr = "-----BEGIN CERTIFICATE REQUEST-----\nMIICvDCCAaQCAQAwdzELMAkGA1UEBhMCVVMxEzARBgNVBAgMCkNhbGlmb3JuaWEx\nFjAUBgNVBAcMDVNhbiBGcmFuY2lzY28xEzARBgNVBAoMCkV4YW1wbGUgQ28xEDAO\nBgNVBAsMB0RldlRlYW0xFDASBgNVBAMMC2V4YW1wbGUuY29tMIIBIjANBgkqhkiG\n9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjd/RepiCLQ5/HfKynijcPdiwygrSgxQeTKPo\nT/WiEaRTaUToW9uDUeiIHK83Tgn2+TIONpMoLJRNG+zslpHybWhVVWNlamkrlRwP\nXFQJzsxDN5+TQugILatLsp680SgMNyyPtDIpT3niiNuQ4NFepQLvQTbjXgj1celb\nU86CCeJzYengTF0ZE9Ra+/SsRTA+oy0fNLChNMc2DBaybccxwV2rNWvlvPdhfB7M\nsel3sw/x2hsbWoYC/kudzYmoDPZKX+XOhCkFwUgwib8V4hbjVLcOYsPBJcROYpRh\n9d5g7xdRlbF1I7dHsCRKnsvkIONtwKQmJ2v/UPqYahjtm2TPUQIDAQABoAAwDQYJ\nKoZIhvcNAQELBQADggEBAFEHOsN2SkB3qFBMk9JR5IDoh8rSUKj/310DOwilOQm+\n5lAwRfcFMYCl9yf4IV+XPPfvT3ahzUFfi8Fc98CDeIxAhEwtuZFlE7LA5+/F4HXM\nH3gzqTFwOZq+Wa2m029/BvcyII830h4Z+gU68R52px7O7wYSbAR/n7t1fh2bxzmW\nKqqjrvCpHoMVpgcm9y2bYTj+HLxgX4/uADFvotQppOWZi0ctam+if3Kqb3Kd2MFD\nvVHZp9NwEoqNPxmFEzcyOk2y1PYhhRja7rjdC6bdAqj6JRt+WSzStvgx7aEsxBQj\nrJCMi+GypGf9xQUfCJBhTDQVQ3fmCKTfddDeeVbJBrA=\n-----END CERTIFICATE REQUEST-----"
};

using (var apiClient = new CSRParserAPIClient("[YOUR_API_KEY]"))
{
    var response = await apiClient.ExecuteAsync(queryOptions);
    Console.WriteLine(Newtonsoft.Json.JsonConvert.SerializeObject(response, Newtonsoft.Json.Formatting.Indented));
}
// HttpClient is automatically disposed here
```

---

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

---

## Customer Support

Need any assistance? [Get in touch with Customer Support](https://apiverve.com/contact?utm_source=nuget&utm_medium=referral&utm_content=readme).

---

## Updates
Stay up to date by following [@apiverveHQ](https://twitter.com/apiverveHQ) on Twitter.

---

## Legal

All usage of the APIVerve website, API, and services is subject to the [APIVerve Terms of Service](https://apiverve.com/terms?utm_source=nuget&utm_medium=referral&utm_content=readme) and all legal documents and agreements.

---

## License
Licensed under the MIT License (MIT)

Copyright (&copy;) 2026 APIVerve, and EvlarSoft LLC

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
