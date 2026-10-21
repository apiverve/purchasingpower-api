# Purchasing Power API - Ruby Gem

Purchasing Power calculates the inflation-adjusted value of money between any two time periods. Find out what $100 from 1990 is worth today, or calculate real returns on investments accounting for inflation.

## Installation

Add this line to your application's Gemfile:

```ruby
gem 'apiverve_purchasingpower'
```

And then execute:

```bash
$ bundle install
```

Or install it yourself as:

```bash
$ gem install apiverve_purchasingpower
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```ruby
require 'apiverve_purchasingpower'

# Initialize the client
client = APIVerve::Purchasingpower::Client.new(api_key: "YOUR_API_KEY")

# Make a request
response = client.execute({
  amount: 100,
  from: "1990",
  to: "2024"
})

# Print the response
puts response
```


### Error Handling

```ruby
begin
  response = client.execute({ amount: 100, from: "1990", to: "2024" })
  puts response["data"]
rescue APIVerve::Purchasingpower::ValidationError => e
  puts "Validation error: #{e.errors.join(', ')}"
rescue APIVerve::Purchasingpower::APIError => e
  puts "API error: #{e.message}"
  puts "Status code: #{e.status_code}"
end
```

### Debug Mode

```ruby
# Enable debug logging
client = APIVerve::Purchasingpower::Client.new(
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

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/purchasingpower?utm_source=rubygems&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/purchasingpower?utm_source=ruby&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/purchasingpower?utm_source=ruby&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This gem is available under the [MIT License](LICENSE).
