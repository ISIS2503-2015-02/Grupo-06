class CreateReportems < ActiveRecord::Migration
  def change
    create_table :reportems do |t|
      t.date :fecha
      t.integer :trayectos

      t.timestamps
    end
  end
end
