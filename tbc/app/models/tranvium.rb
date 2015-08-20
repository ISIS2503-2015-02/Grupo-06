class Tranvium < ActiveRecord::Base
  has_many :reportet, dependent: :destroy
end
