json.array!(@reportets) do |reportet|
  json.extract! reportet, :id, :fecha, :trayectos, :tiempopromedio
  json.url reportet_url(reportet, format: :json)
end
