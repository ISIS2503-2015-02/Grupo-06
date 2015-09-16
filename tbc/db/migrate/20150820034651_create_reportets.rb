class CreateReportets < ActiveRecord::Migration
  def change
    create_table :reportets do |t|
      t.date :fecha
      t.integer :trayectos
      t.time :tiempopromedio

      t.timestamps
    end
  end
end
