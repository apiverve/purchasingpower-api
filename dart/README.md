# Purchasing Power API - Dart/Flutter Client

Purchasing Power calculates the inflation-adjusted value of money between any two time periods. Find out what $100 from 1990 is worth today, or calculate real returns on investments accounting for inflation.

[![pub package](https://img.shields.io/pub/v/apiverve_purchasingpower.svg)](https://pub.dev/packages/apiverve_purchasingpower)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

This is the Dart/Flutter client for the [Purchasing Power API](https://apiverve.com/marketplace/purchasingpower?utm_source=dart&utm_medium=referral&utm_content=readme).

## Installation

Add this to your `pubspec.yaml`:

```yaml
dependencies:
  apiverve_purchasingpower: ^1.2.6
```

Then run:

```bash
dart pub get
# or for Flutter
flutter pub get
```

## Usage

```dart
import 'package:apiverve_purchasingpower/apiverve_purchasingpower.dart';

void main() async {
  final client = PurchasingpowerClient('YOUR_API_KEY');

  try {
    final response = await client.execute({
      'amount': 100,
      'from': '1990',
      'to': '2024'
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

## API Reference

- **API Home:** [Purchasing Power API](https://apiverve.com/marketplace/purchasingpower?utm_source=dart&utm_medium=referral&utm_content=readme)
- **Documentation:** [docs.apiverve.com/ref/purchasingpower](https://docs.apiverve.com/ref/purchasingpower?utm_source=dart&utm_medium=referral&utm_content=readme)

## Authentication

All requests require an API key. Get yours at [apiverve.com](https://apiverve.com?utm_source=dart&utm_medium=referral&utm_content=readme).

## License

MIT License - see [LICENSE](LICENSE) for details.

---

Built with Dart for [APIVerve](https://apiverve.com?utm_source=dart&utm_medium=referral&utm_content=readme)
