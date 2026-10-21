# Purchasing Power API - PHP Package

Purchasing Power calculates the inflation-adjusted value of money between any two time periods. Find out what $100 from 1990 is worth today, or calculate real returns on investments accounting for inflation.

## Installation

Install via Composer:

```bash
composer require apiverve/purchasingpower
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```php
<?php

require_once 'vendor/autoload.php';

use APIVerve\Purchasingpower\Client;

// Initialize the client
$client = new Client('YOUR_API_KEY');

// Make a request
$response = $client->execute([
    'amount' => 100,
    'from' => '1990',
    'to' => '2024'
]);

// Print the response
print_r($response);
```


### Error Handling

```php
use APIVerve\Purchasingpower\Client;
use APIVerve\Purchasingpower\Exceptions\APIException;
use APIVerve\Purchasingpower\Exceptions\ValidationException;

try {
    $response = $client->execute(['amount' => 100, 'from' => '1990', 'to' => '2024']);
    print_r($response['data']);
} catch (ValidationException $e) {
    echo "Validation error: " . implode(', ', $e->getErrors());
} catch (APIException $e) {
    echo "API error: " . $e->getMessage();
    echo "Status code: " . $e->getStatusCode();
}
```

### Debug Mode

```php
// Enable debug logging
$client = new Client(
    apiKey: 'YOUR_API_KEY',
    debug: true
);
```

## Example Response

```json
{
  "status": "ok",
  "error": null,
  "data": {
    "originalAmount": 100,
    "originalPeriod": "1990-01",
    "adjustedAmount": 242.31,
    "adjustedPeriod": "2024-01",
    "cumulativeInflation": 142.31,
    "multiplier": 2.423,
    "explanation": "$100 in 1990-01 has the same purchasing power as $242.31 in 2024-01",
    "fromCPI": 127.4,
    "toCPI": 308.417
  }
}
```

## Requirements

- PHP 7.4 or higher
- Guzzle HTTP client

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/purchasingpower?utm_source=packagist&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/purchasingpower?utm_source=php&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/purchasingpower?utm_source=php&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This package is available under the [MIT License](LICENSE).
