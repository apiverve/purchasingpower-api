/// Response models for the Purchasing Power API.

/// API Response wrapper.
class PurchasingpowerResponse {
  final String status;
  final dynamic error;
  final PurchasingpowerData? data;

  /// Set only when the current plan locks one or more fields; null otherwise.
  final PremiumInfo? premium;

  PurchasingpowerResponse({
    required this.status,
    this.error,
    this.data,
    this.premium,
  });

  factory PurchasingpowerResponse.fromJson(Map<String, dynamic> json) => PurchasingpowerResponse(
    status: json['status'] as String? ?? '',
    error: json['error'],
    data: json['data'] != null ? PurchasingpowerData.fromJson(json['data']) : null,
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

/// Response data for the Purchasing Power API.

class PurchasingpowerData {
  num? originalAmount;
  String? originalPeriod;
  num? adjustedAmount;
  String? adjustedPeriod;
  num? cumulativeInflation;
  num? multiplier;
  String? explanation;
  num? fromCPI;
  num? toCPI;

  PurchasingpowerData({
    this.originalAmount,
    this.originalPeriod,
    this.adjustedAmount,
    this.adjustedPeriod,
    this.cumulativeInflation,
    this.multiplier,
    this.explanation,
    this.fromCPI,
    this.toCPI,
  });

  factory PurchasingpowerData.fromJson(Map<String, dynamic> json) => PurchasingpowerData(
      originalAmount: json['originalAmount'],
      originalPeriod: json['originalPeriod'],
      adjustedAmount: json['adjustedAmount'],
      adjustedPeriod: json['adjustedPeriod'],
      cumulativeInflation: json['cumulativeInflation'],
      multiplier: json['multiplier'],
      explanation: json['explanation'],
      fromCPI: json['fromCPI'],
      toCPI: json['toCPI'],
    );
}

class PurchasingpowerRequest {
  double amount;
  String from;
  String? to;

  PurchasingpowerRequest({
    required this.amount,
    required this.from,
    this.to,
  });

  Map<String, dynamic> toJson() => {
      'amount': amount,
      'from': from,
      if (to != null) 'to': to,
    };
}
